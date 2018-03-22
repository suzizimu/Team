package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Preach;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_preach_add
 */
@WebServlet("/firm_preach_add.do")
public class firm_preach_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_preach_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		String title=request.getParameter("title");
		String address=request.getParameter("address");
		String date=request.getParameter("date");
		String content=request.getParameter("content");
		
		Preach preach=new Preach();
		preach.setAddress(address);
		preach.setContent(content);
		preach.setDate(date);
		preach.setFirmName(FirmName);
		preach.setTitle(title);
		
		firm_service fs=new firm_service();		
		try {
			fs.firm_preach_add(preach);
			
			response.sendRedirect("Back/Public_fabu_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
