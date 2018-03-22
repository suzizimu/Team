package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Log;
import com.back.model.StudentList;
import com.back.model.Teacher;
import com.back.service.log_service;
import com.back.service.studentlist_service;
import com.back.service.teacherlist_service;

/**
 * Servlet implementation class log_list
 */
@WebServlet("/Back/log_list.do")
public class log_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log_service ls=new log_service();
		try{
			List<Log> loglist =ls.listall();
				System.out.println("loglist��Ϊ��");
				System.out.println(loglist);
				request.setAttribute("loglist", loglist);
				request.getRequestDispatcher("/Back/L_log_list.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    } 
	}

}
