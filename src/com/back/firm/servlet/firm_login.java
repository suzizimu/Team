package com.back.firm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;

/**
 * Servlet implementation class firm_login
 */
@WebServlet("/firm_login.do")
public class firm_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=request.getParameter("FirmName");
		String PassWord=request.getParameter("PassWord");
		String Code=request.getParameter("code");
		String rCode=(String) request.getSession().getAttribute("rCode");
		System.out.println(Code);
		
		
		if(("").equals(FirmName.trim())||("").equals(PassWord.trim())){
			request.setAttribute("msg","账号或密码不能为空");
			request.getRequestDispatcher("Back/F_firm_login.jsp").forward(request, response);
		}
		if(("").equals(Code.trim())){
    		request.setAttribute("msg", "验证码不能为空");
    		request.getRequestDispatcher("Back/F_firm_login.jsp").forward(request, response);
    	}
		if((Code.toUpperCase().equals(rCode))){//解决验证码大小写问题
		     firm_service fs=new firm_service();
		     try {
				fs.login(FirmName, PassWord);
				long count=fs.firm_message_count(FirmName);
				
				request.getSession().setAttribute("count",count);
				request.getSession().setAttribute("FirmName", FirmName);
				request.getRequestDispatcher("Back/F_firm_index.jsp").forward(request, response);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Back/F_firm_login.jsp").forward(request, response);
			}
		     
		}else{
			request.setAttribute("msg","验证码错误");
			request.getRequestDispatcher("Back/F_firm_login.jsp").forward(request, response);
		}

	}


}
