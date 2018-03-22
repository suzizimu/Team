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
 * Servlet implementation class admin_update
 */
@WebServlet("/Back/admin_update.do")
public class admin_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String admin_id=request.getParameter("ID");
	       System.out.println("BackUpdateadminID:"+admin_id);
			try {
				//添加日志־
				log_service ls=new log_service();
				Log log=new Log();
				Date now = new Date(); 
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String admin_name =(String) request.getSession().getAttribute("admin_name");
				String date=dateFormat.format( now );
				String type="更新";
				String operate=admin_name+"进行了管理员更新操作";
				
				log.setAdminName(admin_name);
				log.setOperate(operate);
				log.setOperateDate(date);
				log.setType(type);
				ls.addlog(log);
				
				
				admin_service as=new admin_service();
				Admin admin=as.loadadmin(Integer.parseInt(admin_id));
				 System.out.println("AdminUpdateid:"+admin_id);
				System.out.println(admin);
				request.setAttribute("admin_update",admin);
				request.getRequestDispatcher("/Back/A_admin_update.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message",e.getMessage());
				request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String ID=request.getParameter("admin_id");
		String AdminName=request.getParameter("admin_name");
		String PassWord=request.getParameter("password2");	
		 Admin admin=new Admin();
		    admin.setID(Integer.parseInt(ID));
		    admin.setAdminName(AdminName);
		    admin.setPassWord(PassWord);
		try {
			admin_service gs =new admin_service();
			gs.updateadmin(admin);
			response.sendRedirect("/Team/Back/public_add_reload.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/Team/Back/404.jsp").forward(request, response);
		}
	}

}
