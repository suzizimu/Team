package com.back.firm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.back.model.Firm;
import com.back.service.firm_service;

/**
 * Servlet implementation class firm_identification_add
 */
@WebServlet("/firm_identification_update.do")
@MultipartConfig
public class firm_identification_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_identification_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		firm_service fs=new firm_service();
		try {
			Firm firm=fs.firm_identification(FirmName);			
			
			request.setAttribute("firm",firm);
			request.getRequestDispatcher("Back/F_firm_identification.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		Part part=request.getPart("Picture");//接受文件
		System.out.println(part);
		
		String path=request.getServletContext().getRealPath("/up_Picture");//上传文件路径
		
		File folder=new File(path);//创建folder
		if(!folder.exists()){
			folder.mkdirs();
		}
		System.out.println(path);
		/**
		 * Tomcat 8.0版本
		 * 
		 * 但要记得导包，因为FilenameUtils需要两个包，在lib里面。
		 */		
		String submittedfilname=part.getSubmittedFileName();//接受到的文件名
		String name=UUID.randomUUID().toString().replaceAll("-","");//随机生成名字
		String ext=FilenameUtils.getExtension(submittedfilname);//截取文件的后缀名。例如：jpg
		
		part.write(path+"/"+name+"."+ext);
		
		String realpath=request.getContextPath();
		
		String FirmID=request.getParameter("FirmID");
		String CardStart=request.getParameter("CardStart");
		String Picture=realpath+"/up_Picture/"+name+"."+ext;
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		System.out.println(Picture+"**********");
		
		Firm firm=new Firm();		
		firm.setFirmID(FirmID);
		firm.setCardStart(CardStart);
		firm.setPicture(Picture);
		firm.setFirmName(FirmName);
		
		firm_service fs=new firm_service();
		try {
			fs.firm_indentification_update(firm);
			
			
			request.getRequestDispatcher("Back/F_firm_identification_success.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/F_firm_identification.jsp").forward(request, response);
		}	
		
	}

}
