package com.back.service;



import java.util.List;

import com.back.dao.admin_dao;
import com.back.model.Admin;
import com.back.model.Item;
import com.back.model.School;
import com.back.model.StudentList;


public class admin_service {
            admin_dao md=new admin_dao();
            
     //��½       
            public Admin login(String adminname) throws Exception{
    			try {
    				Admin admin=new Admin();
    				admin=md.login(adminname);
    				return admin;
    				
    			} catch (Exception e) {
    				// TODO: handle exception
    				throw new Exception("admin_service"+e.getMessage());	
    			}
    		}  
            //��½״̬�޸�      
            public void loginupdate(String LastTime,String AdminName) throws Exception{
    			try {
    				md.loginupadte(LastTime,AdminName);
    			} catch (Exception e) {
    				// TODO: handle exception
    				throw new Exception("admin_service"+e.getMessage());	
    			}
    		}     
            
	   public List<Admin> listall() throws Exception{
			try {
				System.out.println("admin_service");
				return md.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());	
			}
		}
	   
	   public List<Admin> bestoplistall() throws Exception{
			try {
				System.out.println("ManagerService�㣺Manager�����ɹ�");
				return md.bestoplistall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());	
			}
		}
	   //通过ID查找某个学生
	   public StudentList querystudent(String ID) throws Exception{
			try {
				StudentList student=new StudentList();
				student=md.queryOneStudent(ID);
				return student;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());	
			}
		} 
	   
		public void addmanager(Admin manager) throws Exception{
			try {
				
				md.addmanager(manager);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());
			}
		}
		
		//ɾ��
		public void delmanager(int ID) throws Exception{
			try{
				md.delmanager(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());
			}
			
		}
		
		//ɾ��
				public void delbacthmanager(String ID) throws Exception{
					try{
						md.delbatchmanager(ID);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("admin_service"+e.getMessage());
					}
					
				}
		
		//��ѯ
		public List<Admin> selectmanager(String addtime1,String addtime2,String AdminName) throws Exception{
			try{
				 return md.selectadmin(addtime1, addtime2, AdminName);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());
			}
		}
		
		
		//�޸�
		public Admin loadadmin(int ID){
			try {
				return md.loadadmin(ID);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
				// TODO: handle exception
			}
		}
		
		
		public void updateadmin(Admin admin) throws Exception{
			try {
				md.updateadmin(admin);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());
			}
		}
		//
		
	//����	
		public void start(int ID) throws Exception{
			try {
				md.start(ID);
			} catch (Exception e) {
				// TODO: handle excepadmin_service"+e.getMessage());
			}
		}
	//ͣ��
		public void stop(int ID) throws Exception{
			try {
				md.stop(ID);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("admin_service"+e.getMessage());
			}
		}
		public List<School> queryallschoolupdate() throws Exception{
			try{
				return md.queryallschoolupdate();
			}catch(Exception e){
				throw new Exception("查询所有项目失败，原因是："+e.getMessage());
			}
		}
		
		public int deleteschoolupdate(String id) throws Exception{
			try{
				int i= md.deleteschoolupdate(id);
				if(i>0){
					return i;
				}else{
					throw new Exception("删除信息条数为0");
				}
			}catch(Exception e){
				throw new Exception("删除校正信息失败，原因是："+e.getMessage());
			}
		}
		
		//通过
		public void passschoolupdate(String id) throws Exception{
			try{
				School sch=md.queryonemessagebyid(id);
				//判断是否有值
				String i=md.checkuniversity(sch);
			//	System.out.println(sch);
				if(i!=null){
					Boolean a=md.checkcollege(sch,i);
					if(a){
						//存学院值
						int i1=md.addcollege(sch,i);
					}
				}else{
					//获取省份ID
					String i2=md.queryoneprobyid(sch);
					
					//更新学校
					int i3=md.adduniversity(sch,i2);
					
					//获取学校ID
					String i4=md.checkuniversity(sch);
					
					//更新学院
					int i5=md.addcollege(sch, i4);
				}
				
				int i6=deleteschoolupdate(id);
				
			}catch(Exception e){
				throw new Exception("通过校正信息失败，原因是："+e.getMessage());
			}
			
		}
		
		public List<Item> queryAllItem() throws Exception{
			try{
				return md.queryAllItem();
			}catch(Exception e){
				throw new Exception("查询所有项目失败，原因是："+e.getMessage());
			}
		}
		
		public int openItem(String id) throws Exception{
			try{
				return md.openItem(id);
			}catch(Exception e){
				throw new Exception("启动项目失败，原因是："+e.getMessage());
			}
		}
		
		public int stopItem(String id) throws Exception{
			try{
				return md.stopItem(id);
			}catch(Exception e){
				throw new Exception("停止项目失败，原因是："+e.getMessage());
			}
		}
		
		public int passItem(String id) throws Exception{
			try{
				int i= md.passItem(id);
				if(i>0){
					return i;
				}else{
					throw new Exception("通过项目条数为0");
				}
			}catch(Exception e){
				throw new Exception("通过项目失败，原因是："+e.getMessage());
			}
		}
		
		public int failItem(String id) throws Exception{
			try{
				int i= md.failItem(id);
				if(i>0){
					return i;
				}else{
					throw new Exception("忽略项目条数为0");
				}
			}catch(Exception e){
				throw new Exception("忽略项目失败，原因是："+e.getMessage());
			}
		}
		
		public List<Item> queryAllCheckItem() throws Exception{
			try{
				return md.queryAllCheckItem();
			}catch(Exception e){
				throw new Exception("查询所有项目失败，原因是："+e.getMessage());
			}
		}
	
}

