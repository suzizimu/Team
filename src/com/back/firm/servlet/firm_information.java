package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_information
 */
@WebServlet("/firm_information.do")
public class firm_information extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_information() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
	    System.out.println(FirmName+"***********");
		firm_service fs=new firm_service();
		try {
			Firm firm=fs.firm_information(FirmName);
			
			request.setAttribute("firm", firm);
			request.getRequestDispatcher("Back/F_firm_information.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
