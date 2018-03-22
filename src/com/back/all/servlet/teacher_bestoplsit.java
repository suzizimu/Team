package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Teacher;
import com.back.service.teacherlist_service;

/**
 * Servlet implementation class teacher_bestoplsit
 */
@WebServlet("/Back/teacher_bestoplist.do")
public class teacher_bestoplsit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_bestoplsit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		teacherlist_service tls=new teacherlist_service();
		try{
			List<Teacher> listteacherlist =tls.bestoplistall();
			
				System.out.println("listteacherlist��Ϊ��");
				System.out.println(listteacherlist);
				request.setAttribute("listteacherlist", listteacherlist);
				request.getRequestDispatcher("/Back/T_teacher_bestoplist.jsp").forward(request, response);
			
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    } 
	}

}
