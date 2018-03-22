package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Admin;
import com.back.model.Information;
import com.back.util.DBUtil;

public class imformation_dao {

	public List<Information> listall(){
		String sql ="Select * from information ";
		
		List<Map<String, Object>> lm = DBUtil.list(sql);
		if (lm.size() != 0 && lm != null) {
			List<Information> listinfor = new ArrayList<Information>();
			for (Map<String, Object> map : lm) {
				Information infor = new Information();
				infor.setID((Integer) map.get("ID"));
				infor.setTitle((String) map.get("Title"));
				infor.setDate(((String) map.get("Date")));
				infor.setSkimtime((Integer) map.get("Skimtime"));;
				infor.setSourse((String) map.get("Sourse"));
				infor.setAuthor((String) map.get("Author"));
				infor.setContent((String) map.get("Content"));
				infor.setPicture((String) map.get("Picture"));
				infor.setType((String) map.get("Type"));
				listinfor.add(infor);
			}
			return listinfor;
		} else {
			return null;
		}
	}
	
	public List<Information> listallbytype(String type){
		String sql ="Select * from information where type=? ";
		
		List<Map<String, Object>> lm = DBUtil.list(sql,type);
		if (lm.size() != 0 && lm != null) {
			List<Information> listinfor = new ArrayList<Information>();
			for (Map<String, Object> map : lm) {
				Information infor = new Information();
				infor.setID((Integer) map.get("ID"));
				infor.setTitle((String) map.get("Title"));
				infor.setDate(((String) map.get("Date")));
				infor.setSkimtime((Integer) map.get("Skimtime"));;
				infor.setSourse((String) map.get("Sourse"));
				infor.setAuthor((String) map.get("Author"));
				infor.setContent((String) map.get("Content"));
				infor.setPicture((String) map.get("Picture"));
				infor.setType((String) map.get("Type"));
				listinfor.add(infor);
			}
			return listinfor;
		} else {
			return null;
		}
	}
	
	//确定某一个信息
	public Information queryinfor(int ID){
		String sql="select *from information where ID=?";
		Map<String, Object> map=DBUtil.query(sql,ID);
		if(map.size()>0&&map!=null)
		{
			Information infor=new Information();
			infor.setID((Integer) map.get("ID"));
			infor.setTitle((String) map.get("Title"));
			infor.setDate(((String) map.get("Date")));
			infor.setSkimtime((Integer) map.get("Skimtime"));;
			infor.setSourse((String) map.get("Sourse"));
			infor.setAuthor((String) map.get("Author"));
			infor.setContent((String) map.get("Content"));
			infor.setPicture((String) map.get("Picture"));
			infor.setType((String) map.get("Type"));
			return infor;
		}else{
			return null;
		}
	  }
	//添加
	public void addinformation(Information infor){
		String sql ="insert into information(Title,Date,Sourse,Author,Content,Picture,Type) values(?,?,?,?,?,?,?)";
		DBUtil.executeUpdate(sql,new Object[]{infor.getTitle(),infor.getDate(),infor.getSourse(),infor.getAuthor(),infor.getContent(),infor.getPicture(),infor.getType()});
	}
	//删除
	public void delformation(int ID){
		String sql ="delete from information where ID=?";
		DBUtil.executeUpdate(sql,ID);
	}
	//批量删除
		public void delbatchinfor(String ID){
			System.out.println(ID);
			String sql ="delete from information where ID in "+ID;
			DBUtil.executeUpdate(sql);
		}
	//修改
		public Information loadformation(int ID){
			String sql ="select *from information where ID=?";
			Map<String,Object> map=DBUtil.query(sql,ID);
			if(map.size()>0){
			Information infor = new Information();
			infor.setID((Integer) map.get("ID"));
			infor.setTitle((String) map.get("Title"));
			infor.setDate(((String) map.get("Date")));
			infor.setSkimtime((Integer) map.get("Skimtime"));;
			infor.setSourse((String) map.get("Sourse"));
			infor.setAuthor((String) map.get("Author"));
			infor.setContent((String) map.get("Content"));
			infor.setPicture((String) map.get("Picture"));
			infor.setType((String) map.get("Type"));
			return infor;
			}else{
				return null;
			}	
		}
		

		public void updateformation(Information information){
			String sql ="update information set Title=?,Sourse=?,Author=?,Content=?,Picture=?,Type=?,Date=?where ID=?";
			
			DBUtil.executeUpdate(sql,new Object[]{information.getTitle(),information.getSourse(),information.getAuthor(),information.getContent(),information.getPicture(),information.getType(),information.getDate(),information.getID()});
			System.out.println("informationdao:"+sql);
			
		}
		
		//浏览次数修改
		public void updateinforskim(int ID){
			String sql ="update information set Skimtime=Skimtime+1 where ID=?";
			
			DBUtil.executeUpdate(sql,ID);
			System.out.println("informationdao:"+sql);			
		}
	
		/**
		 * 前台首页遍历政策
		 * @param type
		 * @return
		 */
		public List<Information> F_listallbytype(){
			String sql ="Select * from information where type='创业政策'  limit 0,2 ";
			
			List<Map<String, Object>> lm = DBUtil.list(sql);
			if (lm.size() != 0 && lm != null) {
				List<Information> listinfor = new ArrayList<Information>();
				for (Map<String, Object> map : lm) {
					Information infor = new Information();
					infor.setID((Integer) map.get("ID"));
					infor.setTitle((String) map.get("Title"));
					infor.setDate(((String) map.get("Date")));
					infor.setSkimtime((Integer) map.get("Skimtime"));;
					infor.setSourse((String) map.get("Sourse"));
					infor.setAuthor((String) map.get("Author"));
					infor.setContent((String) map.get("Content"));
					infor.setPicture((String) map.get("Picture"));
					infor.setType((String) map.get("Type"));
					listinfor.add(infor);
				}
				return listinfor;
			} else {
				return null;
			}
		}
}
