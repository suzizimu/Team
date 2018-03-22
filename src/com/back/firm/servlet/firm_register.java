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
 * Servlet implementation class firm_register
 */
@WebServlet("/firm_register.do")
public class firm_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=request.getParameter("FirmName");
		String Email=request.getParameter("Email");
		String Tel=request.getParameter("Tel");
		String PassWord=request.getParameter("PassWord");
		
		Firm firm=new Firm();
		firm.setFirmName(FirmName);
		firm.setEmail(Email);
		firm.setTel(Tel);
		firm.setPassWord(PassWord);
		
		firm_service fs=new firm_service();
		try {
			fs.firm_register(firm);
			
			response.sendRedirect("Back/Public_register_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/F_firm_register.jsp").forward(request, response);
		}
		
		
	}

}
