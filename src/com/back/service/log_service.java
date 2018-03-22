package com.back.service;

import java.util.List;

import com.back.dao.log_dao;
import com.back.model.Admin;
import com.back.model.Log;

public class log_service {
       log_dao ld=new log_dao();
	 public List<Log> listall() throws Exception{
			try {
				System.out.println("LogService层：log遍历成功");
				return ld.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("查询log列表失败，原因为："+e.getMessage());	
			}
		}
	 
	 
	 //添加
	 public void addlog(Log log) throws Exception{
			try {
				
				ld.addlog(log);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("添加失败，原因为："+e.getMessage());
			}
		}
		//删除
		public void dellog(int ID) throws Exception{
			try{
				ld.dellog(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("删除失败，原因为："+e.getMessage());
			}
			
		}
		
		//删除
				public void delbacthlog(String ID) throws Exception{
					try{
						ld.delbatchlog(ID);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("删除失败，原因为："+e.getMessage());
					}
					
				}
				
	//查询
	public List<Log> selectlog(String addtime1,String addtime2,String AdminName) throws Exception{
					try{
						 return ld.selectlog(addtime1, addtime2, AdminName);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("删除失败，原因为："+e.getMessage());
					}
				}		
}
