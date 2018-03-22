package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Message;
import com.back.model.StudentList;
import com.back.service.admin_service;
import com.back.service.messageinsert_service;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class PassItemCheckServlet
 */
@WebServlet("/PassItemCheck.do")
public class PassItemCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassItemCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 通过
		try{
			//初始化
			admin_service adms=new admin_service();
			
			//接值
			String id= request.getParameter("id");
	 
			//启用
			adms.passItem(id);
			
		    admin_service sls=new admin_service();
					Date now = new Date(); 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date2=dateFormat.format( now );
					String  content2;
			        content2="系统消息：您的项目审核验证成功。";
						StudentList student=sls.querystudent(id);
						String receive=student.getStudentName();
						Message message=new Message();
						message.setContent(content2);//
						message.setDate(date2);
						message.setReceive(receive);//公司名
						message.setType("学生");
						messageinsert_service mis=new messageinsert_service();
						mis.addmessagee(message);
			
			//跳转
			request.getRequestDispatcher("ItemCheckSet.do").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
	}

}
