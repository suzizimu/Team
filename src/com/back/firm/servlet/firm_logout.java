package com.back.firm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;
import com.google.gson.Gson;

/**
 * Servlet implementation class firm_logout
 */
@WebServlet("/firm_logout.do")
public class firm_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {			
			request.getSession().setAttribute("FirmName", null);
			response.sendRedirect("Back/F_firm_login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		    request.setAttribute("msg",e.getMessage());
		    request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
