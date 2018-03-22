package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.StudentList;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class student_entrepreneurship
 */
@WebServlet("/Back/student_entrepreneurship.do")
public class student_entrepreneurship extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_entrepreneurship() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		studentlist_service sls=new studentlist_service();
		try{
			List<StudentList> liststudentlist =sls.creachecklist();
			
				System.out.println("liststudentlist��Ϊ��");
				System.out.println(liststudentlist);
				request.setAttribute("liststudentlist", liststudentlist);
				request.getRequestDispatcher("/Back/S_student_entrepreneurship.jsp").forward(request, response);
			
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    }
	}

}
