package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Admin;
import com.back.model.JobFair;
import com.back.service.admin_service;
import com.back.service.jobfair_service;

/**
 * Servlet implementation class jobfair_select
 */
@WebServlet("/Back/jobfair_select.do")
public class jobfair_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobfair_select() {
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

    	// TODO Auto-generated method stub
    	//super.service(arg0, arg1);
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String addtime1=request.getParameter("addtime1");
    	String addtime2=request.getParameter("addtime2");
    	System.out.println(addtime1);
    	System.out.println(addtime2);
    	jobfair_service jfs=new jobfair_service();
    	
    	
        try{
        	List<JobFair> jobfairlist=jfs.selectjobfair(addtime1, addtime2);
        	System.out.println("jobfairlist:"+jobfairlist);
        	request.setAttribute("jobfairlist",jobfairlist);
        	System.out.println("jobfairlist:·¢ËÍjobfairlist³É¹¦");
        	request.getRequestDispatcher("/Back/J_jobfair_list.jsp").forward(request, response);
        	
        }
    	catch(Exception e){
    		request.setAttribute("message", e.getMessage());
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    	}

    }

}
