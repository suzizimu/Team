package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.JobFair;
import com.back.util.DBUtil;

public class jobfair_dao{

		public List<JobFair> listall(){
			String sql ="Select * from job_fair";
			
			List<Map<String, Object>> lm = DBUtil.list(sql);
			if (lm.size() != 0 && lm != null) {				
				List<JobFair> listjobfair = new ArrayList<JobFair>();
				for (Map<String, Object> map : lm) {
					JobFair jobfair = new JobFair();
					
	    			 jobfair.setAddress((String) map.get("Address"));
	    			 jobfair.setDate((String) map.get("Date"));
	    			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
	    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
	    			 jobfair.setID((int) map.get("ID"));
	    			 jobfair.setPostNumber((int) map.get("PostNumber"));
	    			 jobfair.setTitle((String) map.get("Title"));
				
					listjobfair.add(jobfair);
				
				}
			
				return listjobfair;
			} else {
				return null;
			}
		}
		

		public void addjobfair(JobFair jobfair){
			String sql ="insert into job_fair(Title,Address,FirmNumber,Date) values(?,?,?,?,?,?)";
			DBUtil.executeUpdate(sql,new Object[]{jobfair.getTitle(),jobfair.getAddress(),jobfair.getFirmNumber(),jobfair.getDate()});
		}
		//鍒犻櫎
		public void deljobfair(int ID){
			String sql ="delete from job_fair where ID=?";
			DBUtil.executeUpdate(sql,ID);
		}
		//鎵归噺鍒犻櫎
		public void delbatchjobfair(String ID){
			System.out.println(ID);
			String sql ="delete from job_fair where ID in "+ID;
			DBUtil.executeUpdate(sql);
		}
		

		//鏇存柊
		public JobFair loadjobfair(int ID){
			String sql ="select *from job_fair where ID=?";
			Map<String,Object> map=DBUtil.query(sql,ID);
			if(map.size()>0){
			  JobFair jobfair = new JobFair();
			  jobfair.setID((Integer) map.get("ID"));
				jobfair.setTitle((String) map.get("Title"));
				jobfair.setAddress(((String) map.get("Address")));
				jobfair.setFirmNumber((Integer) map.get("FirmNumber"));;
				jobfair.setPostNumber((Integer) map.get("PostNumber"));
				jobfair.setDate((String) map.get("Date"));
				jobfair.setFirmIDs((String) map.get("FirmIDs"));
			return jobfair;
			}else{
				return null;
			}	
		}
		
		
		public void updatejobfair(JobFair jobfair){
			String sql ="update job_fair set Title=?,Address=?,Date=? where ID=?";
			
			DBUtil.executeUpdate(sql,new Object[]{jobfair.getTitle(),jobfair.getAddress(),jobfair.getDate(),jobfair.getID()});
			System.out.println("jobfairdao:锟睫革拷锟斤拷锟�"+sql);
		}
		
		
		
		//鎼滅储		
	public List<JobFair> selectjobfair(String addtime1,String addtime2){
			
			String addtime1_1=addtime1;
			String addtime2_2=addtime2;
			
			String Str1="";
			String Str2="";
			

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
			
		

			
			
			String sql="select *from job_fair  where 1=1 and str_to_date(Date, '%Y-%m-%d') between "+Str1+Str2;
	        System.out.println("JobFairDao灞�"+sql);
	        
	        
		List<Map<String, Object>> lm=DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("JobFairDao灞傦細lm涓嶄负绌�");
			List<JobFair> listjobfair= new ArrayList<JobFair>();
			for (Map<String, Object> map : lm) {
			 JobFair jobfair = new JobFair();
				
   			 jobfair.setAddress((String) map.get("Address"));
   			 jobfair.setDate((String) map.get("Date"));
   			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
   			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
   			 jobfair.setID((int) map.get("ID"));
   			 jobfair.setPostNumber((int) map.get("PostNumber"));
   			 jobfair.setTitle((String) map.get("Title"));
   			 
			 listjobfair.add(jobfair);
			  }
			 System.out.println("JobFairDao灞傦細selectjobfair娣诲姞鎴愬姛");
			    return listjobfair;
			}
		else {
			 System.out.println("JobFairDao灞傦細lm涓虹┖");
			return null;
		}
		
		
		}
	//鍋滅敤鍚敤
	     public void stop_start(String Status,int ID){
		String sql ="update admin Status=?  where ID=?";
		
		DBUtil.executeUpdate(sql,new Object[]{Status,ID});
		System.out.println("admindao:"+sql);
		
	}
}
