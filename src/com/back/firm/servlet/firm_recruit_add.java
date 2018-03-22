package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Recruit;
import com.back.service.firm_service;


/**
 * Servlet implementation class firm_recruit_add
 */
@WebServlet("/firm_recruit_add.do")
public class firm_recruit_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_recruit_add() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		String Job=request.getParameter("MajorID_22");	//职业	
		String Department=request.getParameter("Department");
		String Pay=request.getParameter("Pay");
		String[] Welfare=request.getParameterValues("Welfare");
		String EducationBgd=request.getParameter("EducationBgd");
		String JobNature=request.getParameter("JobNature");
		String Job_Des=request.getParameter("Job_Des");
		String Date=request.getParameter("Date");
		
		System.out.println(Job+"************");
		String temp="";
		for(int i=0;i<Welfare.length;i++){
		      temp=temp+Welfare[i]+","; 
		}
		String temp2=temp.substring(0,temp.length()-1);//除去最后一个逗号。
		System.out.println(temp2);
				
		Recruit recruit=new Recruit();
		recruit.setFirmName(FirmName);
		recruit.setJob(Job);
		recruit.setDepartment(Department);
		recruit.setPay(Pay);
		recruit.setWelfare(temp2);
		recruit.setEducationBgd(EducationBgd);
		recruit.setJobNature(JobNature);
		recruit.setJob_Des(Job_Des);
		recruit.setDate(Date);
		
		firm_service fs=new firm_service();
		try {
			fs.recruit_add(recruit);
			
			response.sendRedirect("Back/Public_add_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
