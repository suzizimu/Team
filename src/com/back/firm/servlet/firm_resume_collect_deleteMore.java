package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;

/**
 * Servlet implementation class firm_resume_collect_deleteMore
 */
@WebServlet("/firm_resume_collect_deleteMore.do")
public class firm_resume_collect_deleteMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_resume_collect_deleteMore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAll=request.getParameter("idAll");
		firm_service fs=new firm_service();
		String[] id=idAll.split(",");//用逗号切割
		try {
			for(int i=0;i<idAll.length();i++){
				fs.firm_resume_collect_delete(Integer.parseInt(id[i]));
			}
			request.getRequestDispatcher("Back/F_firm_resume_collect_deleteMore.jsp").forward(request, response);
			//response.sendRedirect("Back/F_firm_resume_collect_deleteMore.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/F_firm_resume_collect_deleteMore.jsp").forward(request, response);
		}
	}

}
