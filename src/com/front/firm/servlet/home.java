package com.front.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Information;
import com.back.model.JobFair;
import com.back.model.Recruit;
import com.back.model.Teacher;
import com.back.service.firm_service;
import com.back.service.information_service;
import com.back.service.student_service;
import com.back.service.teacher_service;

/**
 * Servlet implementation class home
 */
@WebServlet("/home.so")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		firm_service fs=new firm_service();
		teacher_service ts = new teacher_service();
		student_service ss=new student_service();
		information_service ifm=new information_service();
		try {
			List<JobFair> list1=fs.firm_F_jobfair_list();//招聘会
			List<Firm> list2=fs.firm__F_information();//名企
			List<Teacher> list3 = ts.teacher_three();//名师交流
			List<Recruit> list4=ss.querySixRecruit();//最新职位
			List<Information> list5=ifm.F_listallbytype();
			
			
			request.setAttribute("list1",list1);
			request.setAttribute("list2",list2);
			request.setAttribute("list3",list3);
			request.setAttribute("list4",list4);
			request.setAttribute("list5",list5);
			request.getRequestDispatcher("Front/home.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
		
		
	}

}
