package com.back.service;

import java.util.List;

import com.back.dao.log_dao;
import com.back.model.Admin;
import com.back.model.Log;

public class log_service {
       log_dao ld=new log_dao();
	 public List<Log> listall() throws Exception{
			try {
				System.out.println("LogService�㣺log�����ɹ�");
				return ld.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯlog�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	 
	 
	 //���
	 public void addlog(Log log) throws Exception{
			try {
				
				ld.addlog(log);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("���ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
			}
		}
		//ɾ��
		public void dellog(int ID) throws Exception{
			try{
				ld.dellog(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
			}
			
		}
		
		//ɾ��
				public void delbacthlog(String ID) throws Exception{
					try{
						ld.delbatchlog(ID);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
					
				}
				
	//��ѯ
	public List<Log> selectlog(String addtime1,String addtime2,String AdminName) throws Exception{
					try{
						 return ld.selectlog(addtime1, addtime2, AdminName);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
				}		
}
