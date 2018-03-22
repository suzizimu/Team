package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Log;
import com.back.service.jobfair_service;
import com.back.service.log_service;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class jobfair_batchdelete
 */
@WebServlet("/Back/jobfair_batchdelete.do")
public class jobfair_batchdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobfair_batchdelete() {
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
		String IDarray=request.getParameter("ID");
		String IDS="("+IDarray.replace(" ", ",").substring(1)+")";
		
		System.out.println(IDS);
		try {
			//�����־
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date2=dateFormat.format( now );
			String type="批量删除";
			String operate=admin_name+"进行了招聘会批量删除操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date2);
			log.setType(type);
			ls.addlog(log);
			
			
			jfs.delbacthjobfair(IDS); 	
	        request.getRequestDispatcher("/Back/jobfair_list.do").forward(request, response);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
		
	}
}
