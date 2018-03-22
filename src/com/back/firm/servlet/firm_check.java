package com.back.firm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.firm_service;
import com.back.util.DBUtil;
import com.google.gson.Gson;

/**
 * Servlet implementation class firm_check
 */
@WebServlet("/firm_check.do")
public class firm_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=request.getParameter("param");//特殊：根据param来获取文本框数据
		
		/*准备工作*/
		Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Map<String,String> map=new HashMap<String,String>();
		
	    /*------------------------*/			
		firm_service fs=new firm_service();
		try {
			int num=fs.firm_check(FirmName);			
			if(num>0){
				map.put("info","系统中已经存在该名称");
				map.put("status","n");
			}else{
				map.put("info","该名称可用");
				map.put("status","y");
			}
			
			String jsonmap=gson.toJson(map);
			out.write(jsonmap);
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
