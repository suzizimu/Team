package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;

/**
 * Servlet implementation class firm_jobfair_recruit_add
 */
@WebServlet("/firm_jobfair_recruit_add.do")
public class firm_jobfair_recruit_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_jobfair_recruit_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		System.out.println(FirmName);
		
		String FairID=request.getParameter("FairID");//得到招聘会的ID
		System.out.println(FairID);
		
		String idAll=request.getParameter("idAll");//得到的是recruit职位表的IDs;
		System.out.println(idAll);
		
		String[] id=idAll.split(",");
	    int num=id.length;//id的长度	    
	    System.out.println(num);
	    
	    firm_service fs=new firm_service();
	    try {
			fs.firm_jobfair_recruit_add(FairID, FirmName, idAll, num);
			
			response.sendRedirect("Back/Public_fabu_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/Public_fabu_reload.jsp").forward(request, response);
		}
	    
	}

}
