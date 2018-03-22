package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.FirmList;
import com.back.model.StudentList;
import com.back.util.DBUtil;

public class studentlist_dao {
//学生列表
	public List<StudentList> listall(){
		String sql ="Select * from student where Status=1";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("lm.size()"+lm.size());
			System.out.println("StudentListDao:1.student不为空");
			List<StudentList> liststudent = new ArrayList<StudentList>();
			for (Map<String, Object> map : lm) {
				StudentList student = new StudentList();
				student.setID((Integer) map.get("ID"));
				student.setStudentName((String) map.get("StudentName"));
				student.setRealName((String) map.get("RealName"));
				student.setPassWord(((String) map.get("PassWord")));
				student.setSex((String) map.get("Sex"));
				student.setAge((int) map.get("Age"));
				student.setSchool((String) map.get("School"));
				student.setAcademy((String) map.get("Academy"));
				student.setMajor((String) map.get("Major"));
				student.setHome((String) map.get("Home"));
				student.setTel((String) map.get("Tel"));
				
				student.setEmail((String) map.get("Email"));
				student.setID_Card((String) map.get("ID_Card"));
				student.setPicture((String) map.get("Picture"));
				student.setResume((String) map.get("Resume"));
				student.setResumeTime((String) map.get("ResumeTime"));
				student.setMotto((String) map.get("Motto"));
				student.setStatus((String) map.get("Status"));
				student.setIntention((String) map.get("Intention"));
				student.setEducationBgd((String) map.get("EducationBgd"));
			
				student.setRegisterStatus((String) map.get("RegisterStatus"));
				student.setRegisterTime((String) map.get("RegisterTime"));
				student.setLoginNum((int) map.get("LoginNum"));
				student.setLastLoginTime((String) map.get("LastLoginTime"));
				student.setCheckStatus((String) map.get("CheckStatus"));
				student.setStuPic((String) map.get("StuPic"));
				student.setIdPic((String) map.get("IdPic"));
				student.setCreaPic((String) map.get("CreaPic"));
				student.setCreaStatus((String) map.get("CreaStatus"));
				liststudent.add(student);
			}
			System.out.println("StudentList:3.student不为空");
			return liststudent;
		} else {
			return null;
		}
	}
	//学生停用的列表
	public List<StudentList> bestoplistall(){
		String sql ="Select * from student where Status=0 ";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("lm.size()"+lm.size());
			System.out.println("StudentListDao:1.student不为空");
			List<StudentList> liststudent = new ArrayList<StudentList>();
			for (Map<String, Object> map : lm) {
				StudentList student = new StudentList();
				student.setID((Integer) map.get("ID"));
				student.setStudentName((String) map.get("StudentName"));
				student.setRealName((String) map.get("RealName"));
				student.setPassWord(((String) map.get("PassWord")));
				student.setSex((String) map.get("Sex"));
				student.setAge((int) map.get("Age"));
				student.setSchool((String) map.get("School"));
				student.setAcademy((String) map.get("Academy"));
				student.setMajor((String) map.get("Major"));
				student.setHome((String) map.get("Home"));
				student.setTel((String) map.get("Tel"));
				
				student.setEmail((String) map.get("Email"));
				student.setID_Card((String) map.get("ID_Card"));
				student.setPicture((String) map.get("Picture"));
				student.setResume((String) map.get("Resume"));
				student.setResumeTime((String) map.get("ResumeTime"));
				student.setMotto((String) map.get("Motto"));
				student.setStatus((String) map.get("Status"));
				student.setIntention((String) map.get("Intention"));
				student.setEducationBgd((String) map.get("EducationBgd"));
			
				student.setRegisterStatus((String) map.get("RegisterStatus"));
				student.setRegisterTime((String) map.get("RegisterTime"));
				student.setLoginNum((int) map.get("LoginNum"));
				student.setLastLoginTime((String) map.get("LastLoginTime"));
				student.setCheckStatus((String) map.get("CheckStatus"));
				student.setIdPic((String) map.get("IdPic"));
				student.setCreaPic((String) map.get("CreaPic"));
				student.setCreaStatus((String) map.get("CreaStatus"));
				
				liststudent.add(student);
				System.out.println("StudentList:2.student不为空");
			}
			System.out.println("StudentList:3.student不为空");
			return liststudent;
		} else {
			return null;
		}
	}
	
	/*
	 * 学生认证,通过等于2不通过等于0
	 */
	public List<StudentList> checkstatus(){
		String sql ="Select * from student where CheckStatus=1";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<StudentList> liststudentregister = new ArrayList<StudentList>();
			for (Map<String, Object> map : lm) {
				StudentList student = new StudentList();
				student.setID((Integer) map.get("ID"));
				student.setStudentName((String) map.get("StudentName"));
				student.setRealName((String) map.get("RealName"));
				student.setPassWord(((String) map.get("PassWord")));
				student.setSex((String) map.get("Sex"));
				student.setAge((int) map.get("Age"));
				student.setSchool((String) map.get("School"));
				student.setAcademy((String) map.get("Academy"));
				student.setMajor((String) map.get("Major"));
				student.setHome((String) map.get("Home"));
				student.setTel((String) map.get("Tel"));
				
				student.setEmail((String) map.get("Email"));
				student.setID_Card((String) map.get("ID_Card"));
				student.setPicture((String) map.get("Picture"));
				student.setResume((String) map.get("Resume"));
				student.setResumeTime((String) map.get("ResumeTime"));
				student.setMotto((String) map.get("Motto"));
				student.setStatus((String) map.get("Status"));
				student.setIntention((String) map.get("Intention"));
				student.setEducationBgd((String) map.get("EducationBgd"));
			
				student.setRegisterStatus((String) map.get("RegisterStatus"));
				student.setRegisterTime((String) map.get("RegisterTime"));
				student.setLoginNum((int) map.get("LoginNum"));
				student.setLastLoginTime((String) map.get("LastLoginTime"));
				student.setCheckStatus((String) map.get("CheckStatus"));
				student.setStuPic((String) map.get("StuPic"));
				student.setIdPic((String) map.get("IdPic"));
				student.setCreaPic((String) map.get("CreaPic"));
				student.setCreaStatus((String) map.get("CreaStatus"));
				liststudentregister.add(student);
				
			}
			System.out.println("managerdao锟姐：2manager锟斤拷锟斤拷锟缴癸拷");
			return liststudentregister;
		} else {
			return null;
		}
	}
	
	
	/*
	 * 学生创业认证,通过等于2不通过等于0
	 */
	public List<StudentList> CreaStatus(){
		String sql ="Select * from student where CreaStatus=1 ";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<StudentList> liststudentregister = new ArrayList<StudentList>();
			for (Map<String, Object> map : lm) {
				StudentList student = new StudentList();
				student.setID((Integer) map.get("ID"));
				student.setStudentName((String) map.get("StudentName"));
				student.setRealName((String) map.get("RealName"));
				student.setPassWord(((String) map.get("PassWord")));
				student.setSex((String) map.get("Sex"));
				student.setAge((int) map.get("Age"));
				student.setSchool((String) map.get("School"));
				student.setAcademy((String) map.get("Academy"));
				student.setMajor((String) map.get("Major"));
				student.setHome((String) map.get("Home"));
				student.setTel((String) map.get("Tel"));
				
				student.setEmail((String) map.get("Email"));
				student.setID_Card((String) map.get("ID_Card"));
				student.setPicture((String) map.get("Picture"));
				student.setResume((String) map.get("Resume"));
				student.setResumeTime((String) map.get("ResumeTime"));
				student.setMotto((String) map.get("Motto"));
				student.setStatus((String) map.get("Status"));
				student.setIntention((String) map.get("Intention"));
				student.setEducationBgd((String) map.get("EducationBgd"));
			
				student.setRegisterStatus((String) map.get("RegisterStatus"));
				student.setRegisterTime((String) map.get("RegisterTime"));
				student.setLoginNum((int) map.get("LoginNum"));
				student.setLastLoginTime((String) map.get("LastLoginTime"));
				student.setCheckStatus((String) map.get("CheckStatus"));
				student.setStuPic((String) map.get("StuPic"));
				student.setIdPic((String) map.get("IdPic"));
				student.setCreaPic((String) map.get("CreaPic"));
				student.setCreaStatus((String) map.get("CreaStatus"));
				liststudentregister.add(student);
				
			}
			System.out.println("studentlistdao：2不为空");
			return liststudentregister;
		} else {
			return null;
		}
	}
	//通过ID查找某个学生
	public StudentList querystudent(int ID){
		String sql="select *from student where ID=?";
		Map<String, Object> map=DBUtil.query(sql,ID );
		if(map.size()>0&&map!=null)
		{
			StudentList student = new StudentList();
			student.setID((Integer) map.get("ID"));
			student.setStudentName((String) map.get("StudentName"));
			student.setRealName((String) map.get("RealName"));
			student.setPassWord(((String) map.get("PassWord")));
			student.setSex((String) map.get("Sex"));
			student.setAge((int) map.get("Age"));
			student.setSchool((String) map.get("School"));
			student.setAcademy((String) map.get("Academy"));
			student.setMajor((String) map.get("Major"));
			student.setHome((String) map.get("Home"));
			student.setTel((String) map.get("Tel"));
			System.out.println("4"+((String) map.get("Tel")));
			student.setEmail((String) map.get("Email"));
			student.setID_Card((String) map.get("ID_Card"));
			student.setPicture((String) map.get("Picture"));
			student.setResume((String) map.get("Resume"));
			student.setResumeTime((String) map.get("ResumeTime"));
			student.setMotto((String) map.get("Motto"));
			student.setStatus((String) map.get("Status"));
			student.setIntention((String) map.get("Intention"));
			student.setEducationBgd((String) map.get("EducationBgd"));
			System.out.println("5"+((String) map.get("EducationBgd")));
			student.setRegisterStatus((String) map.get("RegisterStatus"));
			student.setRegisterTime((String) map.get("RegisterTime"));
			student.setLoginNum((int) map.get("LoginNum"));
			student.setLastLoginTime((String) map.get("LastLoginTime"));
			student.setCheckStatus((String) map.get("CheckStatus"));
			student.setIdPic((String) map.get("IdPic"));
			student.setCreaPic((String) map.get("CreaPic"));
			student.setCreaStatus((String) map.get("CreaStatus"));
			System.out.println("6"+((String) map.get("CreaStatus")));
			return student;
		}else{
			return null;
		}
	  }
	
	/*
	 * 鍒犻櫎
	 */
	public void delstudent(int ID){
		String sql ="delete from student where ID=?";
		DBUtil.executeUpdate(sql,ID);
	}
	
	//鎵归噺鍒犻櫎
	public void delbatchstudent(String ID){
		System.out.println(ID);
		String sql ="delete from student where ID in "+ID;
		DBUtil.executeUpdate(sql);
	}
	/*
	 * 绂佺敤鍚敤
	 */
    public void stop_start(String Status,int ID){
	String sql ="update student set Status=?  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{Status,ID});
	System.out.println("studentdao:"+sql);
	
}
    
	/*
	 * 学生认证
	 */
    public void checkstaus(String CheckStatus,int ID){
	String sql ="update student set CheckStatus=?  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{CheckStatus,ID});
	System.out.println("studentdao:"+sql);
	
}
	/*
	 * 创业认证
	 */
    public void checkCreaStatus(String CreaStatus,int ID){
	String sql ="update student set CreaStatus=?  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{CreaStatus,ID});
	System.out.println("studentdao:"+sql);
	
}
    
  //停用
    public void stop(int ID){
	String sql ="update student set Status=0  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("studentdao:"+sql);
}
//启用
    public void start(int ID){
	String sql ="update student set Status=1  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("studentdao:"+sql);
}
}
