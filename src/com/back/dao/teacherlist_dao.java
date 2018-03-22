package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.StudentList;
import com.back.model.Teacher;
import com.back.util.DBUtil;

public class teacherlist_dao {

	/*
	 * 遍历
	 */
	public List<Teacher> listall(){
		String sql ="Select * from teacher where Status=2";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			
			List<Teacher> listtheacher = new ArrayList<Teacher>();
			for (Map<String, Object> map : lm) {
				Teacher teacher = new Teacher();
				teacher.setID((int) map.get("ID"));
	    		teacher.setTeacherName((String) map.get("TeacherName"));
	    		teacher.setSex((String) map.get("Sex"));
	    		teacher.setAge((int) map.get("Age"));
	    		teacher.setPicture((String) map.get("Picture"));
	    		teacher.setEmail((String) map.get("Email"));
	    		teacher.setSpeciality((String) map.get("Speciality"));
	    		teacher.setDes((String) map.get("Des"));
	    		teacher.setSchool((String) map.get("School"));
	    		teacher.setAcademy((String) map.get("Academy"));
	    		teacher.setQualificationCard((String) map.get("QualificationCard"));
	    		teacher.setWorkCard((String) map.get("WorkCard"));
	    		teacher.setStatus((String) map.get("Status"));
				listtheacher.add(teacher);
			}
	
			return listtheacher;
		} else {
			System.out.println("TeacherDao:listteacher为空");
			return null;
		}
	}
	//停用名单
	public List<Teacher> bestoplistall(){
		String sql ="Select * from teacher where Status=0";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			
			List<Teacher> listtheacher = new ArrayList<Teacher>();
			for (Map<String, Object> map : lm) {
				Teacher teacher = new Teacher();
				teacher.setID((int) map.get("ID"));
	    		teacher.setTeacherName((String) map.get("TeacherName"));
	    		teacher.setSex((String) map.get("Sex"));
	    		teacher.setAge((int) map.get("Age"));
	    		teacher.setPicture((String) map.get("Picture"));
	    		teacher.setEmail((String) map.get("Email"));
	    		teacher.setSpeciality((String) map.get("Speciality"));
	    		teacher.setDes((String) map.get("Des"));
	    		teacher.setSchool((String) map.get("School"));
	    		teacher.setAcademy((String) map.get("Academy"));
	    		teacher.setQualificationCard((String) map.get("QualificationCard"));
	    		teacher.setWorkCard((String) map.get("WorkCard"));
	    		teacher.setStatus((String) map.get("Status"));
				listtheacher.add(teacher);
			}
			
			return listtheacher;
		} else {
			System.out.println("TeacherDao:listteacher为空");
			return null;
		}
	}
	//认证中名单
	
	public List<Teacher> registerlistall(){
		String sql ="Select * from teacher where Status=1";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			
			List<Teacher> listtheacher = new ArrayList<Teacher>();
			for (Map<String, Object> map : lm) {
				Teacher teacher = new Teacher();
				teacher.setID((Integer) map.get("ID"));
				teacher.setID((int) map.get("ID"));
	    		teacher.setTeacherName((String) map.get("TeacherName"));
	    		teacher.setSex((String) map.get("Sex"));
	    		teacher.setAge((int) map.get("Age"));
	    		teacher.setPicture((String) map.get("Picture"));
	    		teacher.setEmail((String) map.get("Email"));
	    		teacher.setSpeciality((String) map.get("Speciality"));
	    		teacher.setDes((String) map.get("Des"));
	    		teacher.setSchool((String) map.get("School"));
	    		teacher.setAcademy((String) map.get("Academy"));
	    		teacher.setQualificationCard((String) map.get("QualificationCard"));
	    		teacher.setWorkCard((String) map.get("WorkCard"));
	    		teacher.setStatus((String) map.get("Status"));
				listtheacher.add(teacher);
			}
			
			return listtheacher;
		} else {
			System.out.println("TeacherDao:listteacher为空");
			return null;
		}
	}
	//通过ID查找某个教师
		public Teacher queryteacher(int ID){
			String sql="select *from teacher where ID=?";
			Map<String, Object> map=DBUtil.query(sql,ID );
			if(map.size()>0&&map!=null)
			{
				Teacher teacher = new Teacher();
				teacher.setID((Integer) map.get("ID"));
				teacher.setTeacherName((String) map.get("TeacherName"));
				return teacher;
			}else{
				return null;
			}
		  }
	/*
	 * 删除
	 */
	public void delteacher(int ID){
		String sql ="delete from teacher where ID=?";
		DBUtil.executeUpdate(sql,ID);
	}
	
	//批量删除
		public void delbatchteacher(String ID){
			System.out.println(ID);
			String sql ="delete from teacher where ID in "+ID;
			DBUtil.executeUpdate(sql);
		}
	
	/*
	 * 教师认证
	 */
	    public void teacherregister(String Status,int ID){
		String sql ="update teacher set Status=? where ID=?";
		
		DBUtil.executeUpdate(sql,new Object[]{Status,ID});
		System.out.println("studentdao:"+sql);
		
	}  
//ͣ��
  public void stop(int ID){
	String sql ="update teacher set Status=0  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
}
//����
  public void start(int ID){
	String sql ="update teacher set Status=2  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
}
}
