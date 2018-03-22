package com.front.information.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.FirmList;
import com.back.model.Information;
import com.back.service.firmlist_service;
import com.back.service.information_service;

/**
 * Servlet implementation class information_flist
 */
@WebServlet("/Front/information_frontinforlist.so")
public class information_frontinforlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_frontinforlist() {
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
	information_service ims=new information_service();
	String type=request.getParameter("type");
	try{
		List<Information> listaudition=ims.listallbytype(type);
		if(listaudition!=null){
			request.setAttribute("listaudition", listaudition);
			request.getRequestDispatcher("/Front/FInformation_frontinforlist.jsp").forward(request, response);
		}
	}
	catch(Exception e){
		request.setAttribute("message",e.getMessage());
		request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
	
    }
 }
}
