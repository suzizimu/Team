package com.back.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.back.model.Admin;
import com.back.service.admin_service;

/**
 * Servlet implementation class admin_login
 */
@WebServlet("/Back/admin_login.do")
public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
       protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	       //  super.service(arg0, arg1);
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String admin_name=request.getParameter("admin_name");
		System.out.println("admin_name:"+admin_name);//���
		String password=request.getParameter("password");
		System.out.println("password:"+password);//���
	
		HttpSession session = request.getSession();
		String Verification=(String)session.getAttribute("rCode");//���ɵ���֤��
		String code=request.getParameter("code");//�û��������֤��
		String inputverification=code.toUpperCase();
		System.out.println("inputverification:"+inputverification);//���
		admin_service as=new admin_service();
		if(("").equals(admin_name.trim())||("").equals(password.trim())||("").equals(inputverification.trim())){
			
			request.setAttribute("message", "用户名密码和验证码不能为空");
			System.out.println("1");
			request.getRequestDispatcher("/Back/login.jsp").forward(request, response);
			}else{
				try{
					Admin admin = as.login(admin_name);
					if(admin.getAdminName().equalsIgnoreCase(admin_name)&&admin.getPassWord().equalsIgnoreCase(password)){
					    if(Verification.equals(inputverification)){
							if(admin.getStatus().equalsIgnoreCase("2")){
								String AdminName=admin.getAdminName();
								Date now = new Date(); 
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String LastTime=dateFormat.format( now ); 
								as.loginupdate(LastTime, AdminName);
								
								request.getSession().setAttribute("admin_name",admin.getAdminName());
								response.sendRedirect("/Team/Back/index.jsp");
							}else{
								request.setAttribute("message","你已被禁用");
								System.out.println("2");
								request.getRequestDispatcher("/Back/login.jsp").forward(request, response);
							}
							
						}else{
							request.setAttribute("message","验证码错误");
							System.out.println("3");
							request.getRequestDispatcher("/Back/login.jsp").forward(request, response);
						}	
					}else{
						request.setAttribute("message","用户名或密码不正确");
						System.out.println("4");
						request.getRequestDispatcher("/Back/login.jsp").forward(request, response);
					}
					
				}catch(Exception e){
					
					request.setAttribute("message", e.getMessage());
					System.out.println("5");
					request.getRequestDispatcher("/Back/login.jsp").forward(request, response);
				}
				
			}
   }

}
