package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Log;
import com.back.model.Message;
import com.back.model.StudentList;
import com.back.model.Teacher;
import com.back.service.log_service;
import com.back.service.messageinsert_service;
import com.back.service.teacherlist_service;

/**
 * Servlet implementation class teacher_checkstatus
 */
@WebServlet("/Back/teacher_checkstatus.do")
public class teacher_checkstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_checkstatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
      // super.service(arg0, arg1);
   	teacherlist_service tls=new teacherlist_service();
		String Messege=request.getParameter("messege");
		String[] s=Messege.split(" ");
		System.out.println("aaaaaaaaaaaaaaaaa"+s[0]);
		System.out.println("sssssssssssssssss"+s[1]);
		
	   String ID=s[0];
	   String Status=s[1];
	
		try {
			//�����־
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date2=dateFormat.format( now );
			String type="认证֤";
			String operate=admin_name+"进行了教师认证操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date2);
			log.setType(type);
			ls.addlog(log);
			
			tls.teacherregister(Status,Integer.parseInt(ID));
			
			//添加消息
			String  content2;
			if(Status.equalsIgnoreCase("2")){
				content2="系统消息：您的教师认证成功。";
			}else{
				content2="系统消息：您的教师认证失败。";
			}
			Teacher teacher=tls.queryone(Integer.parseInt(ID));
			String receive=teacher.getTeacherName();
			Message message=new Message();
			message.setContent(content2);//
			message.setDate(date2);
			message.setReceive(receive);//公司名
			message.setType("教师");
			messageinsert_service mis=new messageinsert_service();
			mis.addmessagee(message);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
}

}
