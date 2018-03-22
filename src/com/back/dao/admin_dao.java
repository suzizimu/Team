package com.back.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.back.util.DBUtil;
import com.back.model.Admin;
import com.back.model.Item;
import com.back.model.School;
import com.back.model.StudentList;


public class admin_dao {
	
	public Admin login(String adminname){
		String sql="select *from admin where adminname=?";
		Map<String, Object> map=DBUtil.query(sql,adminname );
		if(map.size()>0&&map!=null)
		{
			Admin admin=new Admin();
			admin.setID((Integer) map.get("ID"));
			admin.setAdminName((String) map.get("AdminName"));
			admin.setCreatName(((String) map.get("CreatTime")));
			admin.setLastTime((String) map.get("LastTime"));;
			admin.setPassWord((String) map.get("PassWord"));
			admin.setLoginNames((String) map.get("LoginTimes"));
			admin.setStatus((String) map.get("Status"));
			return admin;
		}else{
			return null;
		}
	  }
	
	//鐧婚檰鐘舵�佷慨鏀�
    public void loginupadte(String LastTime,String AdminName){
	String sql ="update admin set LastTime=?,LoginTimes=LoginTimes+1 where AdminName like ?";
	DBUtil.executeUpdate(sql,new Object[]{LastTime,AdminName});
	System.out.println("admindao:"+sql);
	
}
	
	//管理员列表
	public List<Admin> listall(){
		String sql ="Select * from admin where Status=2";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<Admin> listadmin = new ArrayList<Admin>();
			for (Map<String, Object> map : lm) {
				Admin admin = new Admin();
				admin.setID((Integer) map.get("ID"));
				admin.setAdminName((String) map.get("AdminName"));
				admin.setCreatName(((String) map.get("CreatTime")));
				admin.setLastTime((String) map.get("LastTime"));;
				admin.setPassWord((String) map.get("PassWord"));
				admin.setLoginNames((String) map.get("LoginTimes"));
				admin.setStatus((String) map.get("Status"));
				listadmin.add(admin);	
			}
			return listadmin;
		} else {
			return null;
		}
	}
	//被禁用管理员列表
	public List<Admin> bestoplistall(){
		String sql ="Select * from admin where Status=0";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<Admin> listadmin = new ArrayList<Admin>();
			for (Map<String, Object> map : lm) {
				Admin admin = new Admin();
				admin.setID((Integer) map.get("ID"));
				admin.setAdminName((String) map.get("AdminName"));
				admin.setCreatName(((String) map.get("CreatTime")));
				admin.setLastTime((String) map.get("LastTime"));;
				admin.setPassWord((String) map.get("PassWord"));
				admin.setLoginNames((String) map.get("LoginTimes"));
				admin.setStatus((String) map.get("Status"));
				System.out.println("MangerDao锟姐：1manager锟斤拷锟斤拷锟缴癸拷");
				listadmin.add(admin);
				
			}
			System.out.println("managerdao锟姐：2manager锟斤拷锟斤拷锟缴癸拷");
			return listadmin;
		} else {
			return null;
		}
	}
	
	//添加
	public void addmanager(Admin admin){
		String sql ="insert into admin(AdminName,PassWord,CreatTime,LoginTimes,LastTime) values(?,?,?,?,?)";
		DBUtil.executeUpdate(sql,new Object[]{admin.getAdminName(),admin.getPassWord(),admin.getCreatName(),admin.getLoginNames(),admin.getLastTime()});
	}
	//删除
	public void delmanager(int ID){
		String sql ="delete from admin where ID=?";
		DBUtil.executeUpdate(sql,ID);
	}
	//批量删除
	public void delbatchmanager(String ID){
		System.out.println(ID);
		String sql ="delete from admin where ID in "+ID;
		DBUtil.executeUpdate(sql);
	}
	

	//修改
	public Admin loadadmin(int ID){
		String sql ="select *from admin where ID=?";
		Map<String,Object> map=DBUtil.query(sql,ID);
		if(map.size()>0){
		  Admin admin = new Admin();
		  admin.setID((int) map.get("ID"));
		  admin.setPassWord((String) map.get("PassWord"));
		  admin.setAdminName((String) map.get("AdminName"));
		  admin.setLoginNames((String) map.get("LoginTimes"));
		  admin.setLastTime((String) map.get("LastTime"));
		  admin.setCreatName((String) map.get("CreatTime"));
		  admin.setStatus((String) map.get("Status"));
		return admin;
		}else{
			return null;
		}	
	}
	
	
	public void updateadmin(Admin admin){
		String sql ="update admin set AdminName=?,PassWord=? where ID=?";
		
		DBUtil.executeUpdate(sql,new Object[]{admin.getAdminName(),admin.getPassWord(),admin.getID()});
		System.out.println("admindao:锟睫革拷锟斤拷锟�"+sql);
		
	}
	//搜索
		
public List<Admin> selectadmin(String addtime1,String addtime2,String adminname ){
		
		String addtime1_1=addtime1;
		String addtime2_2=addtime2;
		String adminname2=adminname;
		
		String Str1="";
		String Str2="";
		String Str3="";
		

		if(addtime1_1!=null&&addtime1_1.trim()!=""){
				 Str1=" and CreatTime between str_to_date('"+addtime1_1+"', '%Y-%m-%d')";
			 }
			else{
				Str1="";
		}


		if(addtime2_2!=null&&addtime2_2.trim()!=""){
			Str2="and str_to_date('"+addtime2_2+"', '%Y-%m-%d')";
		 }
		else{
		 Str2="";
	}
		
		
		if(adminname2!=null&&adminname2.trim()!=""){
			String selectname=adminname2;
			Str3=" and adminname like '%"+selectname+"%'";
		}else{
			 Str3="";
		}

		
		
		String sql="select *from admin  where 1=1   "+Str1+Str2+Str3;
        System.out.println("UserDao灞�"+sql);
        
        
	List<Map<String, Object>> lm=DBUtil.list(sql);
	if (lm.size() != 0 && lm != null) {
		System.out.println("Admindao灞傦細lm涓嶄负绌�");
		List<Admin>listadmin= new ArrayList<Admin>();
		for (Map<String, Object> map : lm) {
			  Admin admin = new Admin();
			  admin.setID((int) map.get("ID"));
			  admin.setPassWord((String) map.get("PassWord"));
			  admin.setAdminName((String) map.get("AdminName"));
			  admin.setLoginNames((String) map.get("LoginTimes"));
			  admin.setLastTime((String) map.get("LastTime"));
			  admin.setCreatName((String) map.get("CreatTime"));
			  admin.setStatus((String) map.get("Status"));
			  listadmin.add(admin);
		  }
		 System.out.println("Admindao灞傦細selectadmin娣诲姞鎴愬姛");
		    return listadmin;
		}
	
	else {
		 System.out.println("Admindao灞傦細lm涓虹┖");
		return null;
	}
	
	
	}
//停用
     public void stop(int ID){
	String sql ="update admin set Status=0  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("admindao:"+sql);
}
 //启用
     public void start(int ID){
	String sql ="update admin set Status=2  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("admindao:"+sql);
}
     
     
     
     
   //查询所有学校校正信息
 	public List<School> queryallschoolupdate(){
 		String sql="select * from updateschoolmessage";
 		List<Map<String,Object>> lmap=DBUtil.list(sql);
 		List<School> lsh=new ArrayList<School>();
 		if(lmap!=null){
 			for(int i=0;i<lmap.size();i++){
 				School sch=new School();
 				sch.setID((int)lmap.get(i).get("ID"));
 				sch.setCollege((String)lmap.get(i).get("College"));
 				sch.setProvince((String)lmap.get(i).get("Province"));
 				sch.setUniversity((String)lmap.get(i).get("University"));
 				sch.setStuID((int)lmap.get(i).get("StuID"));
 				lsh.add(sch);
 			}
 			return lsh;
 		}else{
 			return null;
 		}
 	}
 	
 	//删除校正信息
 	public int deleteschoolupdate(String id){
 		String sql="delete from updateschoolmessage where ID=?";
 		int i=DBUtil.executeUpdate(sql,id);
 		return i;
 	}
 	
 	public School queryonemessagebyid(String id){
 		String sql="select * from updateschoolmessage where ID=?";
 		List<Map<String,Object>> lmap=DBUtil.list(sql,id);
 		if(lmap.size()==1){
 			School sch=new School();
 			for(int i=0;i<lmap.size();i++){
 				sch.setID((int)lmap.get(i).get("ID"));
 				sch.setCollege((String)lmap.get(i).get("College"));
 				sch.setProvince((String)lmap.get(i).get("Province"));
 				sch.setUniversity((String)lmap.get(i).get("University"));
 				sch.setStuID((int)lmap.get(i).get("StuID"));
 				
 			}
 			return sch;
 		}else{
 			return null;
 		}
 	}
 	
 	//判断是否有值(学校)
 	public String checkuniversity(School sch){
 		String sql="select * from cms_university where university=?";
 		List<Map<String,Object>> lmap =DBUtil.list(sql,sch.getUniversity());
 		if(lmap!=null&&lmap.size()==1){
 			return  String.valueOf((int)lmap.get(0).get("university_id"));
 		}else{
 			return null;
 		}
 	}
 	
 	//判断是否有值(学院)
 	public boolean checkcollege(School sch,String id){
 		String sql="select * from cms_college where college=? and university_id=?";
 		List<Map<String,Object>> lmap =DBUtil.list(sql,new Object[]{sch.getCollege(),id});
 		if(lmap!=null&&lmap.size()!=0){
 			return false;
 		}else{
 			return true;
 		}
 	}
 	
 	
 	
 	//存学院值
 	public int addcollege(School sch,String id){
 		String sql="insert into cms_college(college,university_id) values(?,?)";
 		int i=DBUtil.executeUpdate(sql,new Object[]{sch.getCollege(),id});
 		return i;
 	}
 	
 	//获取省份id
 	public String queryoneprobyid(School sch){
 		String sql="select * from cms_provinces where province=?";
 		List<Map<String,Object>> lmap =DBUtil.list(sql,sch.getProvince());
 		if(lmap!=null&&lmap.size()==1){
 			return String.valueOf((int)lmap.get(0).get("province_id"));
 		}else{
 			return null;
 		}
 	}
 	
 	//更新学校
 	public int adduniversity(School sch,String id){
 		String sql="insert into cms_university(university,province_id) values(?,?)";
 		int i=DBUtil.executeUpdate(sql,new Object[]{sch.getUniversity(),id});
 		return i;
 	}
 	
 	
 	//删除更新表
 	public int deleteupdateschool(String id){
 		String sql="delete from updateschoolmessage where ID=?";
 		int i=DBUtil.executeUpdate(sql, id);
 		return i;
 	}
 	
 	//查询项目列表
 			public List<Item> queryAllItem(){
 				String sql="select * from stu_start";
 				List<Map<String,Object>> lmap=DBUtil.list(sql);
 				List<Item> lte=new ArrayList<Item>();
 				if(lmap!=null){
 					for(int i=0;i<lmap.size();i++){
 						Item ite=new Item();				
 						ite.setAddresss((String)lmap.get(i).get("Addresss"));
 						ite.setBusinessPlan((String)lmap.get(i).get("BusinessPlan"));
 						ite.setCheckStatus((String)lmap.get(i).get("CheckStatus"));				
 						ite.setDescripe((String)lmap.get(i).get("Descripe"));
 						ite.setEmail((String)lmap.get(i).get("Email"));
 						ite.setFirmID((int)lmap.get(i).get("FirmID"));
 						ite.setFirmName((String)lmap.get(i).get("FirmName"));				
 						ite.setID((int)lmap.get(i).get("ID"));				
 						ite.setIntention((String)lmap.get(i).get("Intention"));
 						ite.setItemName((String)lmap.get(i).get("ItemName"));
 						ite.setNeedDiscripe((String)lmap.get(i).get("NeedDiscripe"));
 						ite.setNumber((int)lmap.get(i).get("Number"));
 						ite.setPatentNum((int)lmap.get(i).get("PatentNum"));
 						ite.setQQ((String)lmap.get(i).get("QQ"));
 						ite.setSchool((String)lmap.get(i).get("School"));
 						ite.setStatus((String)lmap.get(i).get("Status"));
 						ite.setStuID((int)lmap.get(i).get("StuID"));
 						ite.setStuName((String)lmap.get(i).get("StuName"));
 						ite.setTel((String)lmap.get(i).get("Tel"));
 						ite.setNeedNumber((int)lmap.get(i).get("NeedNumber"));
 						lte.add(ite);
 					}
 					return lte;
 				}else{
 					return null;
 				}
 			}
 			//通过ID查找某一个项目
 			public StudentList queryOneStudent(String stuid){
 				StudentList stu= new StudentList();
 				String sql ="select * from student where ID=?";
 				Map<String,Object> map=DBUtil.query(sql, stuid);
 				if(map!=null){
 					//把值存进Student类
 					stu.setAcademy((String)map.get("Academy"));
 					stu.setAge((int)map.get("Age"));
 					stu.setEducationBgd((String)map.get("EducationBgd"));
 					stu.setEmail((String)map.get("Email"));
 					stu.setHome((String)map.get("Home"));
 					stu.setID((int)map.get("ID"));
 					stu.setID_Card((String)map.get("ID_Card"));
 					stu.setIntention((String)map.get("Intention"));
 					stu.setMajor((String)map.get("Major"));
 					stu.setMotto((String)map.get("Motto"));
 					stu.setPassWord((String)map.get("PassWord"));
 					stu.setPicture((String)map.get("Picture"));
 					stu.setProvince((String)map.get("Province"));
 					stu.setResume((String)map.get("Resume"));
 					stu.setResumeTime((String)map.get("ResumeTime"));
 					stu.setSchool((String)map.get("School"));
 					stu.setSex((String)map.get("Sex"));
 					stu.setStatus((String)map.get("Status"));
 					stu.setStudentName((String)map.get("StudentName"));
 					stu.setTel((String)map.get("Tel"));
 					stu.setRegisterTime((String)map.get("RegisterTime"));
 					stu.setRealName((String)map.get("RealName"));
 					stu.setRegisterStatus((String)map.get("RegisterStatus"));
 					stu.setLastLoginTime((String)map.get("LastLoginTime"));
 					stu.setLoginNum((int)map.get("LoginNum"));
 					stu.setCheckStatus((String)map.get("CheckStatus"));
 					stu.setStuPic((String)map.get("StuPic"));
 					stu.setIdPic((String)map.get("IdPic"));
 					stu.setCreaPic((String)map.get("CreaPic"));
 					stu.setCreaStatus((String)map.get("CreaStatus"));
 				}
 				return stu;
 			}
 			
 			//查询所有验证项目
 			public List<Item> queryAllCheckItem(){
 				String sql="select * from stu_start where Status='1' and CheckStatus='1'";
 				List<Map<String,Object>> lmap=DBUtil.list(sql);
 				List<Item> lte=new ArrayList<Item>();
 				if(lmap!=null){
 					for(int i=0;i<lmap.size();i++){
 						Item ite=new Item();				
 						ite.setAddresss((String)lmap.get(i).get("Addresss"));
 						ite.setBusinessPlan((String)lmap.get(i).get("BusinessPlan"));
 						ite.setCheckStatus((String)lmap.get(i).get("CheckStatus"));				
 						ite.setDescripe((String)lmap.get(i).get("Descripe"));
 						ite.setEmail((String)lmap.get(i).get("Email"));
 						ite.setFirmID((int)lmap.get(i).get("FirmID"));
 						ite.setFirmName((String)lmap.get(i).get("FirmName"));				
 						ite.setID((int)lmap.get(i).get("ID"));				
 						ite.setIntention((String)lmap.get(i).get("Intention"));
 						ite.setItemName((String)lmap.get(i).get("ItemName"));
 						ite.setNeedDiscripe((String)lmap.get(i).get("NeedDiscripe"));
 						ite.setNumber((int)lmap.get(i).get("Number"));
 						ite.setPatentNum((int)lmap.get(i).get("PatentNum"));
 						ite.setQQ((String)lmap.get(i).get("QQ"));
 						ite.setSchool((String)lmap.get(i).get("School"));
 						ite.setStatus((String)lmap.get(i).get("Status"));
 						ite.setStuID((int)lmap.get(i).get("StuID"));
 						ite.setStuName((String)lmap.get(i).get("StuName"));
 						ite.setTel((String)lmap.get(i).get("Tel"));
 						ite.setNeedNumber((int)lmap.get(i).get("NeedNumber"));
 						lte.add(ite);
 					}
 					return lte;
 				}else{
 					return null;
 				}
 			}
 			
 			//启动项目
 			public int openItem(String id){
 				String sql="update stu_start set Status='1' where ID=?";
 				int i=DBUtil.executeUpdate(sql,id);
 				return i;
 			}
 			
 			//禁用项目
 			public int stopItem(String id){
 				String sql="update stu_start set Status='0' where ID=?";
 				int i=DBUtil.executeUpdate(sql,id);
 				return i;
 			}
 			
 			//通过项目
 			public int passItem(String id){
 				String sql="update stu_start set CheckStatus='2' where ID=?";
 				int i=DBUtil.executeUpdate(sql,id);
 				return i;
 			}
 			
 			//不通过项目
 			public int failItem(String id){
 				String sql="update stu_start set CheckStatus='0' where ID=?";
 				int i=DBUtil.executeUpdate(sql,id);
 				return i;
 			}
}

