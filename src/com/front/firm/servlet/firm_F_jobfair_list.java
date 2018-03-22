package com.front.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.JobFair;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_F_jobfair_list
 */
@WebServlet("/firm_F_jobfair_list.so")
public class firm_F_jobfair_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_F_jobfair_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		firm_service fs=new firm_service();
		try {
			List<JobFair> list=fs.firm_F_jobfair_list2();
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("Front/jobfair_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
		
	}

}
