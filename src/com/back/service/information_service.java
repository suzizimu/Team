package com.back.service;

import java.util.List;

import com.back.dao.imformation_dao;
import com.back.model.Admin;
import com.back.model.Information;

public class information_service {
    imformation_dao ifm=new imformation_dao();
	  public List<Information> listall() throws Exception{
			try {
				System.out.println("InformationService");
				return ifm.listall();
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("InformationService"+e.getMessage());	
			}
		}
	  //分类遍历
	  public List<Information> listallbytype(String type) throws Exception{
			try {
				System.out.println("InformationService");
				return ifm.listallbytype(type);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("InformationService"+e.getMessage());	
			}
		}
	  
	  //确定某一个
	   public Information qureyinfor(int ID) throws Exception{
			try {
				Information infor=new Information();
				infor=ifm.queryinfor(ID);
				return infor;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("��½ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());	
			}
		}
	 // 添加
		public void addinformation(Information infor) throws Exception{
			try {
				
				ifm.addinformation(infor);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("���ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
			}
		}
		
		//删除
		public void delinformation(int ID) throws Exception{
			try{
				ifm.delformation(ID);
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
			}
			
		}
		
		//批量删除
				public void delbacthformation(String ID) throws Exception{
					try{
						ifm.delbatchinfor(ID);
					}catch (Exception e) {
						// TODO: handle exception
						throw new Exception("ɾ��ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
					
				}
				//更新
				public Information loadinformation(int ID){
					try {
						return ifm.loadformation(ID);
					} catch (Exception e) {
						e.printStackTrace();
						return null;
						// TODO: handle exception
					}
				}
				
				
				public void updateinformation(Information information) throws Exception{
					try {
						ifm.updateformation(information);
					} catch (Exception e) {
						// TODO: handle exception
						throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
				}
				
				//修改浏览次数
				public void updateinforskim(int ID) throws Exception{
					try {
						ifm.updateinforskim(ID);
					} catch (Exception e) {
						// TODO: handle exception
						throw new Exception("����ʧ�ܣ�ԭ��Ϊ��"+e.getMessage());
					}
				}
				/**
				 * 前台遍历政策
				 * @return
				 * @throws Exception
				 */
				public List<Information> F_listallbytype() throws Exception{
					try {
						return ifm.F_listallbytype();
					} catch (Exception e) {
						// TODO: handle exception
						throw new Exception("前台遍历政策失败，原因是："+e.getMessage());
					}
				}
}
