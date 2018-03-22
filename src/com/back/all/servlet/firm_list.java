package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.FirmList;
import com.back.model.StudentList;
import com.back.service.firmlist_service;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class firm_list
 */
@WebServlet("/Back/firm_list.do")
public class firm_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		firmlist_service fls=new firmlist_service();
		try{
			List<FirmList> listfirmlist =fls.listall();
			
				System.out.println("listfirmlist��Ϊ��");
				System.out.println(listfirmlist);
				request.setAttribute("listfirmlist", listfirmlist);
				request.getRequestDispatcher("/Back/F_firm_list.jsp").forward(request, response);
			
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    }
	}
}
