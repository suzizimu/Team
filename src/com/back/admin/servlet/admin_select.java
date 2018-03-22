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
 * Servlet implementation class admin_select
 */
@WebServlet("/Back/admin_select.do")
public class admin_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_select() {
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

	// TODO Auto-generated method stub
	//super.service(arg0, arg1);
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String addtime1=request.getParameter("addtime1");
	String addtime2=request.getParameter("addtime2");
	System.out.println(addtime1);
	System.out.println(addtime2);
	String adminname=request.getParameter("adminname");
	System.out.println(adminname);
	admin_service as=new admin_service();
	
    try{
    	List<Admin> listadmin=as.selectmanager(addtime1,addtime2,adminname);
    	System.out.println("listadmin:"+listadmin);
    	request.setAttribute("listadmin",listadmin);
    	System.out.println("listadmin:·¢ËÍlistadmin³É¹¦");
    	request.getRequestDispatcher("/Back/A_admin_list.jsp").forward(request, response);
    	
    }
	catch(Exception e){
		request.setAttribute("message", e.getMessage());
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}

}
