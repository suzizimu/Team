package com.back.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Admin;
import com.back.service.admin_service;

/**
 * Servlet implementation class admin_bestoplist
 */
@WebServlet("/Back/admin_bestoplist.do")
public class admin_bestoplist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_bestoplist() {
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
		admin_service as=new admin_service();
		try{
			List<Admin> listadmin =as.bestoplistall();
				System.out.println("listadmin��Ϊ��");
				System.out.println(listadmin);
				request.setAttribute("listadmin", listadmin);
				request.getRequestDispatcher("/Back/A_admin_bestoplist.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    }
	}

}
