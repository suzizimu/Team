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

/**
 * Servlet implementation class information_add
 */
@WebServlet("/Back/information_add.do")
@MultipartConfig()
public class information_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Information infor=new Information();
		information_service ifs=new information_service();
		
        Part part=request.getPart("myfile");
        String path =request.getServletContext().getRealPath("/information_picture");
        String realpath=request.getContextPath();
		File folder=new File(path);
		if(!(folder.exists())){
			folder.mkdirs();
		}
		String head=part.getHeader("content-disposition");
		System.out.println(head);
		String name=UUID.randomUUID().toString().replaceAll("-","");
		String ext=head.substring(head.lastIndexOf("."),head.length()-1);
		System.out.println(name);
	    System.out.println(ext);
		part.write(path+"/"+name+ext);
		request.setAttribute("name", name+ext);
		
		String title=request.getParameter("title");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=dateFormat.format( now ); 
		String sourse=request.getParameter("sourse");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
	    String goodphoto=realpath+"/information_picture/"+name+ext;
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
			
			String type2="添加";
			String operate=admin_name+"进行了信息添加操作";
			
			log.setAdminName(admin_name);
			log.setOperate(operate);
			log.setOperateDate(date);
			log.setType(type2);
			ls.addlog(log);
	    	
	    	
	    	
	    	ifs.addinformation(infor);
			response.sendRedirect("/Team/Back/public_reload.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("information_add.jsp").forward(request, response);
			
		}
	}
}
