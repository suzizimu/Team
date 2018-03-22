package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.FirmList;
import com.back.model.Log;
import com.back.model.Message;
import com.back.service.firmlist_service;
import com.back.service.log_service;
import com.back.service.messageinsert_service;

/**
 * Servlet implementation class firm_checkstatus
 */
@WebServlet("/Back/firm_checkstatus.do")
public class firm_checkstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_checkstatus() {
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
      	firmlist_service fls=new firmlist_service();
		String Messege=request.getParameter("messege");
		String[] s=Messege.split(" ");
		System.out.println("aaaaaaaaaaaaaaaaa"+s[0]);
		System.out.println("sssssssssssssssss"+s[1]);
		
	   String ID=s[0];//ID
	   System.out.println("ID:"+ID);
	   String Status=s[1];//认证状态
	   System.out.println("status:"+Status);
	
		try {
			
			
		   //添加日志־
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date=dateFormat.format( now );
			String type="��ҵ��֤";
			String operate=admin_name+"��������ҵ��֤����";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date);
			log.setType(type);
			ls.addlog(log);
			
			
			fls.stop_start(Status,Integer.parseInt(ID));
			
			
			//添加消息
			String  content2;
			if(Status.equalsIgnoreCase("Yes")){
				content2="系统消息：您的企业身份验证成功。";
			}else{
				content2="系统消息：您的企业身份验证失败。";
			}
			FirmList firm=fls.queryone(Integer.parseInt(ID));
			String receive=firm.getFirmName();
			
			System.out.println("receive:"+receive);
			Message message=new Message();
			message.setContent(content2);//
			message.setDate(date);
			message.setReceive(receive);//公司名
			message.setType("企业");
			messageinsert_service mis=new messageinsert_service();
			mis.addmessagee(message);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
}

}
