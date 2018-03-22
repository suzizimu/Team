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
 * Servlet implementation class firm_resume_collect_delete
 */
@WebServlet("/firm_resume_collect_delete.do")
public class firm_resume_collect_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_resume_collect_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resume_id=request.getParameter("resume_id");
		
		Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    Map<String,Object> map=new HashMap<String,Object>();
	    /*-----------------------*/
	    firm_service fs=new firm_service();
	    try {
			fs.firm_resume_collect_delete(Integer.parseInt(resume_id));
			
			map.put("info","删除成功");
			map.put("status","y");
			String jsonmap=gson.toJson(map);
			out.write(jsonmap);
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	    
	}

}
