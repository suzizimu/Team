package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Admin;
import com.back.model.Information;
import com.back.service.admin_service;
import com.back.service.information_service;

/**
 * Servlet implementation class information_list
 */
@WebServlet("/Back/information_list.do")
public class information_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		information_service ims=new information_service();
		try{
			List<Information> listinformation=ims.listall();
			
				System.out.println("listinformationservlet");
				request.setAttribute("listinformation", listinformation);
				request.getRequestDispatcher("/Back/I_information_list.jsp").forward(request, response);
			
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    }
	}
}
