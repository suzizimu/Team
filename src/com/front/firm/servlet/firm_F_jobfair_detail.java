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
 * Servlet implementation class firm_F_jobfair_detail
 */
@WebServlet("/firm_F_jobfair_detail.so")
public class firm_F_jobfair_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_F_jobfair_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID=request.getParameter("ID");
		firm_service fs=new firm_service();
		try {
			JobFair jobfair=fs.firm_F_jobfair_detail(Integer.parseInt(ID));
			List<JobFair> list=fs.firm_F_jobfair_attend_list(Integer.parseInt(ID));
			
			
			request.setAttribute("jobfair",jobfair);
			request.setAttribute("list",list);
			request.getRequestDispatcher("Front/jobfair_detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
