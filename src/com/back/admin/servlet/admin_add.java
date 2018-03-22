package com.back.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Admin;
import com.back.model.Log;
import com.back.service.admin_service;
import com.back.service.log_service;

/**
 * Servlet implementation class admin_add
 */
@WebServlet("/Back/admin_add.do")
public class admin_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(request, response);
		admin_service as=new admin_service();
		Admin ad=new Admin(); 
		
		String AdminName=request.getParameter("admin_name");
		String PassWord=request.getParameter("password2");
		System.out.println(PassWord);
		
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String CreatTime=dateFormat.format( now ); 
		System.out.println(CreatTime);
		String lastTime="未登录";
		
		String LoginTimes="0";
		ad.setAdminName(AdminName);
		ad.setPassWord(PassWord);
		ad.setCreatName(CreatTime);
		ad.setLoginNames(LoginTimes);
		ad.setLastTime(lastTime);
		

		
		
		try {
			//添加日志
			log_service ls=new log_service();
			Log log=new Log();
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date=dateFormat.format( now );
			String type="添加";
			String operate=admin_name+"进行了添加管理员操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date);
			log.setType(type);
			ls.addlog(log);
			
			as.addmanager(ad);
			response.sendRedirect("/Team/Back/public_add_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
	}


}
