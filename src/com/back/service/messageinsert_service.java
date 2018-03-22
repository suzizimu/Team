package com.back.service;

import com.back.dao.messageinsert_dao;
import com.back.model.Admin;
import com.back.model.Message;

public class messageinsert_service {

	messageinsert_dao mid=new messageinsert_dao();
	public void addmessagee(Message message) throws Exception{
		try {
			
			mid.addmessage(message);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("admin_service"+e.getMessage());
		}
	}
}
