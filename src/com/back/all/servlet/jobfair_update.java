package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Admin;
import com.back.model.JobFair;
import com.back.model.Log;
import com.back.service.admin_service;
import com.back.service.jobfair_service;
import com.back.service.log_service;

/**
 * Servlet implementation class jobfair_update
 */
@WebServlet("/Back/jobfair_update.do")
public class jobfair_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobfair_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String ID=request.getParameter("ID");
	       System.out.println("BackUpdatejobfair:"+ID);
			try {
				jobfair_service jfs=new jobfair_service();
				JobFair jobfair=jfs.loadjobfair(Integer.parseInt(ID));
				System.out.println(jobfair);
				
				//�����־
				
				
				request.setAttribute("jobfair_update",jobfair);
				request.getRequestDispatcher("/Back/J_jobfair_update.jsp").forward(request, response);
				
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
	
		String title=request.getParameter("title");
		System.out.println("BackUpdatetitle:"+title);
		String ID=request.getParameter("id");
		String address=request.getParameter("address");	
		String date=request.getParameter("addtime");
		 JobFair jobfair=new JobFair();
		 jobfair.setID(Integer.parseInt(ID)); 
		 jobfair.setTitle(title);
		 jobfair.setAddress(address);
		 jobfair.setDate(date); 
		try {
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date2=dateFormat.format( now );
			String type="更新";
			String operate=admin_name+"进行了招聘会更新操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date2);
			log.setType(type);
			ls.addlog(log);
			
			
			
			jobfair_service js =new jobfair_service();
			js.updatejobfair(jobfair);
			response.sendRedirect("/Team/Back/public_reload.jsp");
			return;
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}

	}

}
