package com.back.all.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.FirmList;
import com.back.model.Log;
import com.back.model.Message;
import com.back.service.firmlist_service;
import com.back.service.log_service;
import com.back.service.messageinsert_service;
import com.back.service.studentlist_service;

/**
 * Servlet implementation class firm_start
 */
@WebServlet("/Back/firm_start.do")
public class firm_start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO Auto-generated method stub
   // super.service(arg0, arg1);
	   String ID=request.getParameter("ID");
		firmlist_service fls=new firmlist_service();
		try {
		//�����־
		log_service ls=new log_service();
		Log log=new Log();
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String admin_name =(String) request.getSession().getAttribute("admin_name");
		String date2=dateFormat.format( now );
		String type="启用";
		String operate=admin_name+"进行了公司启用操作";
		
		log.setAdminName(admin_name);
		log.setOperate(operate);
		log.setOperateDate(date2);
		log.setType(type);
		ls.addlog(log);
			
	  fls.start(Integer.parseInt(ID));
	  
	//添加消息
		String  content2="系统消息：您的企业已被启用";
		
		FirmList firm=fls.queryone(Integer.parseInt(ID));
		String receive=firm.getFirmName();
		
		System.out.println("receive:"+receive);
		Message message=new Message();
		message.setContent(content2);//
		message.setDate(date2);
		message.setReceive(receive);//公司名
		message.setType("企业");
		messageinsert_service mis=new messageinsert_service();
		mis.addmessagee(message);
	  
		
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("/Back/404.jsp").forward(request, response);
		}
}

}
