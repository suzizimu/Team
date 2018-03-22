package com.back.dao;

import com.back.model.Admin;
import com.back.model.Message;
import com.back.util.DBUtil;

public class messageinsert_dao {
 
	public void addmessage(Message message){
		String sql ="insert into message(Content,Type,Date,Receive) values(?,?,?,?)";
		DBUtil.executeUpdate(sql,new Object[]{message.getContent(),message.getType(),message.getDate(),message.getReceive()});
	}
}
