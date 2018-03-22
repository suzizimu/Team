package com.back.service;

import java.util.List;

import com.back.dao.firmlist_dao;
import com.back.model.Admin;
import com.back.model.FirmList;

public class firmlist_service {
     
	firmlist_dao fld=new firmlist_dao();
	
	  //列表
	  public List<FirmList> listall() throws Exception{
			try {
				System.out.println("FirmListService�㣺FirmList�����ɹ�");
				return fld.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯFirmList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  //停用列表
	  public List<FirmList> bestoplistall() throws Exception{
			try {
				System.out.println("FirmListService�㣺FirmList�����ɹ�");
				return fld.bestoplistall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��ѯFirmList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	  public FirmList queryone(int ID) throws Exception{
			try {
				FirmList firm=new FirmList();
				firm=fld.queryfirm(ID);
				return firm;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("firm_service"+e.getMessage());	
			}
		}
	  
	  
	  
		//ɾ��
		public void delfirm(int ID) throws Exception{
			try{
				fld.delfirm(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
			}
			
		}
		
		//����ɾ��
				public void delbacthfirm(String ID) throws Exception{
					try{
						fld.delbatchfirm(ID);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
					
				}
				
		/*
		 * ����������֤
		 */
				public void stop_start(String Status,int ID) throws Exception{
					try {
						fld.stop_start(Status,ID);
					} catch (Exception e) {
						// TODO: handle exception
						throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
				}
				
				/*
				 * ��˾��֤
				 */
	 public List<FirmList> firmregister() throws Exception{
				try {
							System.out.println("FirmListService�㣺FirmList�����ɹ�");
							return fld.listregister();
						} catch (Exception e) {
							// TODO: handle exception
							throw new Exception("��ѯFirmList�б�ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
						}
					}
	 
	  //启用
			public void start(int ID) throws Exception{
				try {
					fld.start(ID);
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
				}
			}
		//停用
			public void stop(int ID) throws Exception{
				try {
					fld.stop(ID);
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
				}
			}
}
