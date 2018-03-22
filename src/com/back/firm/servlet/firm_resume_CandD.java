package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;

/**
 * Servlet implementation class firm_resume_CandD
 */
@WebServlet("/firm_resume_CandD.do")
public class firm_resume_CandD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_resume_CandD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAll=request.getParameter("idAll");
		String[] id=idAll.split(",");
		firm_service fs=new firm_service();
		try {
			for(int i=0;i<idAll.length();i++){
				fs.firm_resume_CandD(Integer.parseInt(id[i]));//先收藏
				fs.firm_resume_delete(Integer.parseInt(id[i]));//再删除
			}
			response.sendRedirect("Back/F_firm_resume_collectMore.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/F_firm_resume_collectMore.jsp").forward(request, response);
		}		
	}
}
