package com.back.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Resume;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_resume_collect_select
 */
@WebServlet("/firm_resume_collect_select.do")
public class firm_resume_collect_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_resume_collect_select() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String EducationBgd=request.getParameter("EducationBgd");
		String Job=request.getParameter("MajorID_22");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		System.out.println(date1+"******"+date2);
		
		firm_service fs=new firm_service();
		try {
			List<Resume> list=fs.firm_resume_collect_select(EducationBgd, Job, date1, date2);
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("Back/F_firm_resume_collect_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
