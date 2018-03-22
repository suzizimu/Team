package com.back.service;

import java.util.List;

import com.back.dao.admin_dao;
import com.back.dao.jobfair_dao;
import com.back.model.Admin;
import com.back.model.JobFair;
import com.back.model.Teacher;

public class jobfair_service {


    jobfair_dao jfd=new jobfair_dao();
     
    
public List<JobFair> listall() throws Exception{
	try {
		System.out.println("JobService层：Manager遍历成功");
		return jfd.listall();
	} catch (Exception e) {
		// TODO: handle exception
		throw new Exception("查询JobService列表失败，原因为："+e.getMessage());	
	}
}



public void addjobfair(JobFair jobfair) throws Exception{
	try {
		
		jfd.addjobfair(jobfair);
	} catch (Exception e) {
		// TODO: handle exception
		throw new Exception("添加失败，原因为："+e.getMessage());
	}
}

//删除
public void deljobfair(int ID) throws Exception{
	try{
		jfd.deljobfair(ID);
	}catch (Exception e) {
		// TODO: handle exception
		throw new Exception("删除失败，原因为："+e.getMessage());
	}
	
}

//删除
		public void delbacthjobfair(String ID) throws Exception{
			try{
				jfd.delbatchjobfair(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("删除失败，原因为："+e.getMessage());
			}
			
		}



//修改
public JobFair loadjobfair(int ID){
	try {
		return jfd.loadjobfair(ID);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
		// TODO: handle exception
	}
}


public void updatejobfair(JobFair jobfair) throws Exception{
	try {
		jfd.updatejobfair(jobfair);
	} catch (Exception e) {
		// TODO: handle exception
		throw new Exception("更新失败，原因为："+e.getMessage());
	}
}

//查询
public List<JobFair> selectjobfair(String addtime1,String addtime2) throws Exception{
	try{
		 return jfd.selectjobfair(addtime1, addtime2);
	}catch (Exception e) {
		// TODO: handle exception
		throw new Exception("查询失败，原因为："+e.getMessage());
	}
}

}




