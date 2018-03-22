package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.JobFair;
import com.back.model.Teacher;
import com.back.service.jobfair_service;
import com.back.service.teacherlist_service;

/**
 * Servlet implementation class jobfair_list
 */
@WebServlet("/Back/jobfair_list.do")
public class jobfair_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobfair_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		jobfair_service jfs=new jobfair_service();
		try{
			List<JobFair> jobfairlist =jfs.listall();
			
				System.out.println(jobfairlist);
				request.setAttribute("jobfairlist", jobfairlist);
				request.getRequestDispatcher("/Back/J_jobfair_list.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    } 
	}

}
