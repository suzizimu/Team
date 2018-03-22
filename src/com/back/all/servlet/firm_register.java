package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.FirmList;
import com.back.model.Message;
import com.back.service.firmlist_service;

/**
 * Servlet implementation class firm_register
 */
@WebServlet("/Back/firm_register.do")
public class firm_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		firmlist_service fls=new firmlist_service();
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=dateFormat.format( now );
		
			
		try{
			List<FirmList> listfirmlist =fls.firmregister();
				System.out.println("listfirmlist��Ϊ��");
				System.out.println(listfirmlist);
				request.setAttribute("listfirmlist", listfirmlist);
				request.getRequestDispatcher("/Back/F_firm_register.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		
	    }
	}

}
