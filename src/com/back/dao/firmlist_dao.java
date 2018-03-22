package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.FirmList;
import com.back.model.Information;
import com.back.model.StudentList;
import com.back.util.DBUtil;

public class firmlist_dao {

	public List<FirmList> listall(){
		String sql ="Select * from firm where Status='Yes'";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("FirmListDao:lm涓嶄负绌�");
			List<FirmList> listfirm = new ArrayList<FirmList>();
			for (Map<String, Object> map : lm) {
				FirmList firm = new FirmList();
				firm.setID((Integer) map.get("ID"));
				firm.setFirmName((String) map.get("FirmName"));
				firm.setFirmCode((String) map.get("FirmCode"));
				firm.setPassWord((String) map.get("PassWord"));
				firm.setType((String) map.get("Type"));
				firm.setArea((String) map.get("Area"));
				firm.setAdress((String) map.get("Adress"));
				firm.setLinkMan((String) map.get("LinkMan"));
				firm.setTel((String) map.get("Tel"));
				firm.setEmail((String) map.get("Email"));
				firm.setPeopeNumber((String) map.get("PeopeNumber"));
				firm.setDes((String) map.get("Des"));
				firm.setFirmID((String) map.get("FirmID"));
				firm.setPicture((String) map.get("Picture"));
				firm.setLogo((String) map.get("Logo"));
				firm.setCardStart((String) map.get("CardStart"));
				firm.setStatus((String) map.get("Status"));
				System.out.println("FirmListDao:1涓嶄负绌�");
				listfirm.add(firm);
				
			}
			System.out.println("FirmListDao:2涓嶄负绌�");
			return listfirm;
		} else {
			System.out.println("FirmListDao:lm涓虹┖");
			return null;
		}
	}
	//被禁用企业列表
	public List<FirmList> bestoplistall(){
		String sql ="Select * from firm where Status='No'";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			System.out.println("FirmListDao:lm涓嶄负绌�");
			List<FirmList> listfirm = new ArrayList<FirmList>();
			for (Map<String, Object> map : lm) {
				FirmList firm = new FirmList();
				firm.setID((Integer) map.get("ID"));
				firm.setFirmName((String) map.get("FirmName"));
				firm.setFirmCode((String) map.get("FirmCode"));
				firm.setPassWord((String) map.get("PassWord"));
				firm.setType((String) map.get("Type"));
				firm.setArea((String) map.get("Area"));
				firm.setAdress((String) map.get("Adress"));
				firm.setLinkMan((String) map.get("LinkMan"));
				firm.setTel((String) map.get("Tel"));
				firm.setEmail((String) map.get("Email"));
				firm.setPeopeNumber((String) map.get("PeopeNumber"));
				firm.setDes((String) map.get("Des"));
				firm.setFirmID((String) map.get("FirmID"));
				firm.setPicture((String) map.get("Picture"));
				firm.setLogo((String) map.get("Logo"));
				firm.setCardStart((String) map.get("CardStart"));
				firm.setStatus((String) map.get("Status"));
				System.out.println("FirmListDao:1涓嶄负绌�");
				listfirm.add(firm);
				
			}
			System.out.println("FirmListDao:2涓嶄负绌�");
			return listfirm;
		} else {
			System.out.println("FirmListDao:lm涓虹┖");
			return null;
		}
	}
	//通过ID查找某个企业
	public FirmList queryfirm(int ID){
		String sql="select *from firm where ID=?";
		Map<String, Object> map=DBUtil.query(sql,ID );
		if(map.size()>0&&map!=null)
		{
			FirmList firm = new FirmList();
			firm.setID((Integer) map.get("ID"));
			firm.setFirmName((String) map.get("FirmName"));
			firm.setFirmCode((String) map.get("FirmCode"));
			firm.setPassWord((String) map.get("PassWord"));
			firm.setType((String) map.get("Type"));
			firm.setArea((String) map.get("Area"));
			firm.setAdress((String) map.get("Adress"));
			firm.setLinkMan((String) map.get("LinkMan"));
			firm.setTel((String) map.get("Tel"));
			firm.setEmail((String) map.get("Email"));
			firm.setPeopeNumber((String) map.get("PeopeNumber"));
			firm.setDes((String) map.get("Des"));
			firm.setFirmID((String) map.get("FirmID"));
			firm.setPicture((String) map.get("Picture"));
			firm.setLogo((String) map.get("Logo"));
			firm.setCardStart((String) map.get("CardStart"));
			firm.setStatus((String) map.get("Status"));
			System.out.println("firmlist_dao通过ID查找");
			return firm;
		}else{
			return null;
		}
	  }
	
	
	/*
	 * 认证列表
	 */
	public List<FirmList> listregister(){
		String sql ="Select * from firm where status='Ing'";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<FirmList> listfirmregister = new ArrayList<FirmList>();
			for (Map<String, Object> map : lm) {
				FirmList firm = new FirmList();
				firm.setID((Integer) map.get("ID"));
				firm.setFirmName((String) map.get("FirmName"));
				firm.setFirmCode((String) map.get("FirmCode"));
				firm.setPassWord((String) map.get("PassWord"));
				firm.setType((String) map.get("Type"));
				firm.setArea((String) map.get("Area"));
				firm.setAdress((String) map.get("Adress"));
				firm.setLinkMan((String) map.get("LinkMan"));
				firm.setTel((String) map.get("Tel"));
				firm.setEmail((String) map.get("Email"));
				firm.setPeopeNumber((String) map.get("PeopeNumber"));
				firm.setDes((String) map.get("Des"));
				firm.setFirmID((String) map.get("FirmID"));
				firm.setPicture((String) map.get("Picture"));
				firm.setLogo((String) map.get("Logo"));
				firm.setCardStart((String) map.get("CardStart"));
				firm.setStatus((String) map.get("Status"));
				listfirmregister.add(firm);
				
			}
			System.out.println("firmlistdao锟姐：2manager锟斤拷锟斤拷锟缴癸拷");
			return listfirmregister;
		} else {
			return null;
		}
	}
	
	/*
	 * 鍒犻櫎
	 */
	public void delfirm(int ID){
		String sql ="delete from firm where ID=?";
		DBUtil.executeUpdate(sql,ID);
	}
	
	//鎵归噺鍒犻櫎
	public void delbatchfirm(String ID){
		System.out.println(ID);
		String sql ="delete from firm  where ID in "+ID;
		DBUtil.executeUpdate(sql);
	}
	
	
	/*
	 * 绂佺敤锛屽惎鐢�,璁よ瘉
	 */
     public void stop_start(String Status,int ID){
	   String sql ="update firm set Status=? where ID=?";
	   DBUtil.executeUpdate(sql,new Object[]{Status,ID});
	   System.out.println("firmlistdao:"+sql);
	
   }
	
   //停用
     public void stop(int ID){
	String sql ="update firm set Status='No'  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("firmdao:"+sql);
}
 //启用
     public void start(int ID){
	String sql ="update firm set Status='Yes'  where ID=?";
	
	DBUtil.executeUpdate(sql,new Object[]{ID});
	System.out.println("firmdao:"+sql);
}
}
