package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.Log;
import com.back.util.DBUtil;

public class log_dao {
  
	public List<Log> listall(){
		String sql ="Select *from log";		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("lm不为空");
			List<Log> listlog = new ArrayList<Log>();
			for (Map<String, Object> map : lm) {
				Log log = new Log();
				log.setID((Integer) map.get("ID"));
				log.setAdminName((String) map.get("AdminName"));
				log.setOperate((String) map.get("Operate"));
				log.setOperateDate((String) map.get("OperateDate"));
				log.setType((String) map.get("Type"));
				listlog.add(log);
			}
			return listlog;
		} else {
			System.out.println("lm为空");
			return null;
		}
	}
	
	
	
	
	//添加
	public void addlog(Log log){
		String sql ="insert into log(AdminName,Type,Operate,OperateDate) values(?,?,?,?)";
		DBUtil.executeUpdate(sql,new Object[]{log.getAdminName(),log.getType(),log.getOperate(),log.getOperateDate()});
	}
	//删除
		public void dellog(int ID){
			String sql ="delete from log where ID=?";
			DBUtil.executeUpdate(sql,ID);
		}
		//批量删除
		public void delbatchlog(String ID){
			System.out.println(ID);
			String sql ="delete from log where ID in "+ID;
			DBUtil.executeUpdate(sql);
		}
	
		//搜索
		public List<Log> selectlog(String addtime1,String addtime2,String adminname ){
			
			String addtime1_1=addtime1;
			String addtime2_2=addtime2;
			String adminname2=adminname;
			
			String Str1="";
			String Str2="";
			String Str3="";
			

			if(addtime1_1!=null&&addtime1_1.trim()!=""){
					 Str1=" str_to_date('"+addtime1_1+"', '%Y-%m-%d')";
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
				Str3=" and AdminName like '%"+adminname2+"%'";
			}else{
				 Str3="";
			}

			
			
			String sql="select *from log  where 1=1 and str_to_date(OperateDate,'%Y-%m-%d') between "+Str1+Str2+Str3;
	        System.out.println("LogDao层"+sql);
	        
	        
		List<Map<String, Object>> lm=DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("LogDao层：lm不为空");
			List<Log>listlog= new ArrayList<Log>();
			for (Map<String, Object> map : lm) {
				  Log log = new Log();
				  log.setID((Integer) map.get("ID"));
					log.setAdminName((String) map.get("AdminName"));
					log.setOperate((String) map.get("Operate"));
					log.setOperateDate((String) map.get("OperateDate"));
					log.setType((String) map.get("Type"));
					listlog.add(log);
			  }
			 System.out.println("LogDao层：selectlog添加成功");
			    return listlog;
			}
		
		else {
			 System.out.println("LogDao层：lm为空");
			return null;
		}
		
		
		}
		
}
