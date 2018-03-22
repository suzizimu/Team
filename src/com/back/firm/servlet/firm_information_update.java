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
 * Servlet implementation class firm_information_add
 */
@WebServlet("/firm_information_update.do")
@MultipartConfig
public class firm_information_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_information_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part=request.getPart("Logo");//接受文件
		System.out.println(part);
		
		String path=request.getServletContext().getRealPath("/up_Logo");//上传文件路径
		
		File folder=new File(path);//在"xx"路径下建了一个folder
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
		//因为怕文件上传重名覆盖原文件问题，所以要弄一个随机取名的方法。
		//利用截取方法 来让“随机生成的文件名”与 “原文件的格式”结合
		String name=UUID.randomUUID().toString().replaceAll("-", "");//随机生成名字
		String ext=FilenameUtils.getExtension(submittedfilname);//截取文件的后缀名。例如： jpg
		
		part.write(path+"/"+name+"."+ext);//把要传入的  文件  写入(图片用这个地址)
		
		String realpath=request.getContextPath();
		
		String Logo=realpath+"/up_Logo/"+name+"."+ext;
		String FirmName=request.getParameter("FirmName");
		String Type=request.getParameter("Type");
		String PeopleNumber=request.getParameter("PeopleNumber");
		String Area=request.getParameter("Area");
		String Adress=request.getParameter("map");
		String LinkMan=request.getParameter("LinkMan");
		String Tel=request.getParameter("Tel");
		String Email=request.getParameter("Email");
		String Des=request.getParameter("Des");
		
		System.out.println(Logo+"**************"+Adress);
		
		Firm firm=new Firm();
		firm.setAdress(Adress);
		firm.setArea(Area);
		firm.setDes(Des);
		firm.setEmail(Email);
		firm.setFirmName(FirmName);
		firm.setLinkMan(LinkMan);
		firm.setLogo(Logo);
		firm.setPeopleNumber(PeopleNumber);
		firm.setTel(Tel);
		firm.setType(Type);
		
		firm_service fs=new firm_service();
		try {
			fs.firm_information_update(firm);
			
			response.sendRedirect("Back/Public_update_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/F_firm_information.jsp").forward(request, response);
		}
		
		
	}

}
