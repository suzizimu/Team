package com.back.all.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.back.model.Information;
import com.back.model.Log;
import com.back.service.information_service;
import com.back.service.log_service;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class information_update
 */
@WebServlet("/Back/information_update.do")
@MultipartConfig
public class information_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String ID=request.getParameter("ID");
	       System.out.println("BackUpdateINFORMATION:"+ID);
			try {
				information_service ifs=new information_service();
				Information infor=ifs.loadinformation(Integer.parseInt(ID));
				request.setAttribute("infor_update",infor);
				request.getRequestDispatcher("/Back/I_information_update.jsp").forward(request, response);
				 System.out.println("标记");
			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message",e.getMessage());
				request.getRequestDispatcher("/BackStage/404.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Information infor=new Information();
		information_service ifs=new information_service();
		String sourse=request.getParameter("sourse");
		String ID=request.getParameter("ID");
		System.out.println("BackUpdateInforDopost:"+ID);
		System.out.println("sourse:"+sourse);
        Part part=request.getPart("myfile");
        System.out.println("part:"+part);
        String path =request.getServletContext().getRealPath("/information_picture");
        String realpath=request.getContextPath();
		File folder=new File(path);
		if(!(folder.exists())){
			folder.mkdirs();
		}
		String head=part.getHeader("content-disposition");
		System.out.println("head:"+head);
		String name=UUID.randomUUID().toString().replaceAll("-","");
		String ext=head.substring(head.lastIndexOf("."),head.length()-1);
		System.out.println("name:"+name);
	    System.out.println("ext"+ext);
		part.write(path+"/"+name+ext);
		request.setAttribute("name", name+ext);
		
		String title=request.getParameter("title");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=dateFormat.format( now ); 
	
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
	    String goodphoto=realpath+"/information_picture/"+name+ext;
	    infor.setID(Integer.parseInt(ID));
	    infor.setTitle(title);
	    infor.setSourse(sourse);
	    infor.setAuthor(author);
	    infor.setContent(content);
	    infor.setType(type);
	    infor.setPicture(goodphoto);
	    infor.setDate(date);
    
	    try {
	    	//添加日志־
			log_service ls=new log_service();
			Log log=new Log();
		
			String admin_name =(String) request.getSession().getAttribute("admin_name");
			
			String type2="更新";
			String operate=admin_name+"进行了信息更新操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date);
			log.setType(type2);
			ls.addlog(log);
	    	
	    	
	    	
	    	
	    	ifs.updateinformation(infor);
			response.sendRedirect("/Team/Back/public_reload.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("404.jsp").forward(request, response);
			
		}
	}

}
