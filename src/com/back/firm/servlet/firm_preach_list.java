package com.back.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Preach;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_preach_list
 */
@WebServlet("/firm_preach_list.do")
public class firm_preach_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_preach_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		
		firm_service fs=new firm_service();
		try {
			Firm firm=fs.firm_status(FirmName);//判断企业状态
			String Status=firm.getStatus();
			if(Status.equals("No")||Status.equals("Ing")){
				request.getRequestDispatcher("firm_identification_update.do").forward(request, response);				
			}else{
				List<Preach> list=fs.firm_preach_list(FirmName);
				
				request.setAttribute("list",list);
				request.getRequestDispatcher("Back/F_firm_preach_list.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
