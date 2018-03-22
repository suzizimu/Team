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
 * Servlet implementation class jobfair_add
 */
@WebServlet("/Back/jobfair_add.do")
public class jobfair_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobfair_add() {
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
		jobfair_service jfs=new jobfair_service();
		JobFair jf=new JobFair(); 
		String title=request.getParameter("title");
		String address=request.getParameter("address");
		String firmnumber=request.getParameter("firmnumber");
		String date=request.getParameter("addtime");
		
		jf.setTitle(title);
		jf.setAddress(address);
		jf.setFirmNumber(Integer.parseInt(firmnumber));
		jf.setDate(date);
		
		try {
			//�����־
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date2=dateFormat.format( now );
			String type="添加";
			String operate=admin_name+"添加进行了招聘会操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date2);
			log.setType(type);
			ls.addlog(log);
			
			jfs.addjobfair(jf);
			response.sendRedirect("/Team/Back/public_add_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
	}

}
