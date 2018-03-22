package com.back.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Student;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_intention
 */
@WebServlet("/firm_intention.do")
public class firm_intention extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_intention() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String EducationBgd=request.getParameter("EducationBgd");
		String Job=request.getParameter("MajorID_22");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		System.out.println(date1+"******"+date2);
		
		firm_service fs=new firm_service();
		try {
			Firm firm=fs.firm_status(FirmName);//判断企业状态
			String Status=firm.getStatus();
			if(Status.equals("No")||Status.equals("Ing")){
				response.sendRedirect("firm_identification_update.do");
					
			}else{
				
				List<Student> list=fs.firm_intention_select(EducationBgd, Job, date1, date2);
				
				request.setAttribute("list",list);
				request.getRequestDispatcher("Back/F_firm_intention_list.jsp").forward(request, response);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
