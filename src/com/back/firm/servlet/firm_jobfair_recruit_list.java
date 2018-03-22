package com.back.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Recruit;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_jobfair_recruit_list
 */
@WebServlet("/firm_jobfair_recruit_list.do")
public class firm_jobfair_recruit_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_jobfair_recruit_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FairID=request.getParameter("FairID");
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		firm_service fs=new firm_service();
		try {
			List<Recruit> list=fs.firm_recruit_list(FirmName);
			
			request.setAttribute("FairID",FairID);
			request.setAttribute("list",list);
			request.getRequestDispatcher("Back/F_firm_jobfair_recruit_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
