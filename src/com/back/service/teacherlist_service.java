package com.back.service;

import java.util.List;

import com.back.dao.teacherlist_dao;
import com.back.model.StudentList;
import com.back.model.Teacher;
import com.back.util.DBUtil;

public class teacherlist_service {
   teacherlist_dao td=new teacherlist_dao();
    
   public List<Teacher> listall() throws Exception{
			try {
				System.out.println("TeacherService�㣺Teacher�����ɹ�");
				return td.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯTeacher�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
   
   public List<Teacher> bestoplistall() throws Exception{
		try {
			System.out.println("TeacherService�㣺Teacher�����ɹ�");
			return td.bestoplistall();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("��ѯTeacher�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
		}
	}
   public List<Teacher> registerlistall() throws Exception{
 		try {
 			System.out.println("TeacherService�㣺Teacher�����ɹ�");
 			return td.registerlistall();
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new Exception("��ѯTeacher�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
 		}
 	}
   
   //通过ID查找某个老师
   public Teacher queryone(int ID) throws Exception{
		try {
			Teacher teacher=new Teacher();
			teacher=td.queryteacher(ID);
			return teacher;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("student_service"+e.getMessage());	
		}
	}
   
   //  教师认证
   public void teacherregister(String Status,int ID) throws Exception{
		try {
			td.teacherregister(Status, ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("student_service"+e.getMessage());	
		}
	
}
   public void delteacher(int ID) throws Exception{
		try{
			td.delteacher(ID);
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
		}
		
	}



	public void delbacthteacher(String ID) throws Exception{
						try{
							td.delbatchteacher(ID);
						}catch (Exception e) {
							// TODO: handle exception
							throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
						}
						
					}
	//����	
	public void start(int ID) throws Exception{
		try {
			td.start(ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
		}
	}
//ͣ��
	public void stop(int ID) throws Exception{
		try {
			td.stop(ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
		}
	}
}
