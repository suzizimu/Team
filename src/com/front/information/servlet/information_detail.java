package com.front.information.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Information;
import com.back.service.information_service;

/**
 * Servlet implementation class information_detail
 */
@WebServlet("/Front/information_detail.so")
public class information_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID=request.getParameter("ID");
		System.out.println(ID);
		information_service ims=new information_service();
		
		try {
			ims.updateinforskim(Integer.parseInt(ID));
			Information infor=ims.qureyinfor(Integer.parseInt(ID));
			request.setAttribute("infor", infor);
			request.getRequestDispatcher("/Front/FInformation_detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
