package com.back.all.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Information;
import com.back.service.information_service;

/**
 * Servlet implementation class information_onedetail
 */
@WebServlet("/Back/information_onedetail.do")
public class information_onedetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_onedetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		information_service ifs=new information_service();
		String ID=request.getParameter("ID");
		System.out.println("information_onedetail:"+ID);
		try {
			Information infor=ifs.qureyinfor(Integer.parseInt(ID));
			request.setAttribute("infor", infor);
			request.getRequestDispatcher("/Back/information_show.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
	}

}
