package com.back.service;

import java.util.List;
import com.back.dao.studentlist_dao;
import com.back.model.Admin;
import com.back.model.StudentList;
import com.back.util.DBUtil;

public class studentlist_service {
     
	studentlist_dao sld=new studentlist_dao();
	//遍历
	  public List<StudentList> listall() throws Exception{
			try {
				System.out.println("StudentListService�㣺StudentList�����ɹ�");
				return sld.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  //停用名单
	  public List<StudentList> bestoplistall() throws Exception{
			try {
				System.out.println("StudentListService�㣺StudentList�����ɹ�");
				return sld.bestoplistall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  //学生认证名单
	  public List<StudentList> checkstatuslist() throws Exception{
			try {
				System.out.println("StudentListService�㣺StudentList�����ɹ�");
				return sld.checkstatus();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  //学生创业认证名单
	  public List<StudentList> creachecklist() throws Exception{
			try {
				System.out.println("StudentListService�㣺StudentList�����ɹ�");
				return sld.CreaStatus();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  //通过ID查找一个学生
	  public StudentList queryone(int ID) throws Exception{
			try {
				StudentList student=new StudentList();
				student=sld.querystudent(ID);
				return student;
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("student_service"+e.getMessage());	
			}
		}
	  
	//删除
			public void delstudent(int ID) throws Exception{
				try{
					sld.delstudent(ID);
				}catch (Exception e) {
					// TODO: handle exception
					throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
				}
				
			}
			
	//批量删除
			public void delbacthstudent(String ID) throws Exception{
						try{
							sld.delbatchstudent(ID);
						}catch (Exception e) {
							// TODO: handle exception
							throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
						}
						
					}
						
					
					
					
					/*
					 * ��������
					 */
							public void stop_start(String Status,int ID) throws Exception{
								try {
									sld.stop_start(Status,ID);
								} catch (Exception e) {
									// TODO: handle exception
									throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
								}
							}
							
					/*
					 *学生认证 ֤
					 */
				public void checkstatus(String CheckStatus,int ID) throws Exception{
								try {
									sld.checkstaus(CheckStatus,ID);
								} catch (Exception e) {
									// TODO: handle exception
									throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
								}
							}
				
				/*
				 * 创业认证֤
				 */
			public void checkCreaStatus(String CreaStatus,int ID) throws Exception{
							try {
								sld.checkCreaStatus(CreaStatus, ID);
							} catch (Exception e) {
								// TODO: handle exception
								throw new Exception("��ѯStudentList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
							}
						}
			//启用	
			public void start(int ID) throws Exception{
				try {
					sld.start(ID);
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
				}
			}
		//停用
			public void stop(int ID) throws Exception{
				try {
					sld.stop(ID);
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
				}
			}
}
