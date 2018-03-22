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
import com.google.gson.Gson;

/**
 * Servlet implementation class firm_checkPWD
 */
@WebServlet("/firm_checkPWD.do")
public class firm_checkPWD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_checkPWD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirmName=(String) request.getSession().getAttribute("FirmName");
		String pwd=request.getParameter("param");
		
		Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Map<String,String> map=new HashMap<String,String>();
		
		firm_service fs=new firm_service();
		try {
			int num=fs.firm_checkPWD(FirmName, pwd);
			
			if(num>0){
				map.put("info", "原始密码验证正确");
				map.put("status", "y");
			}else{
				map.put("info", "旧密码验证错误");
				map.put("status", "n");
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
