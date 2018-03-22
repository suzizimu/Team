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
import com.back.service.firmlist_service;
import com.back.service.log_service;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class firmlist_delete
 */
@WebServlet("/Back/firmlist_delete.do")
public class firmlist_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firmlist_delete() {
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
	   String ID=request.getParameter("ID");
  		firmlist_service sls=new firmlist_service();
  		try {
  		//添加日志־
			log_service ls=new log_service();
			Log log=new Log();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			String date=dateFormat.format( now );
			String type="删除";
			String operate=admin_name+"进行了企业删除操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date);
			log.setType(type);
			ls.addlog(log);
  			
  			
  			
  			sls.delfirm(Integer.parseInt(ID));
  		}  catch (Exception e) {
  			// TODO Auto-generated catch block
  			request.setAttribute("message",e.getMessage());
  			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
  		}
}

}
