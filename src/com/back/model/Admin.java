package com.back.model;

public class Admin {
	private int ID;
	private String AdminName;
	private String PassWord;
	private String CreatName;
	private String LoginNames;
	private String LastTime;
	private String Status;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getCreatName() {
		return CreatName;
	}
	public void setCreatName(String creatName) {
		CreatName = creatName;
	}
	public String getLoginNames() {
		return LoginNames;
	}
	public void setLoginNames(String loginNames) {
		LoginNames = loginNames;
	}
	public String getLastTime() {
		return LastTime;
	}
	public void setLastTime(String lastTime) {
		LastTime = lastTime;
	}
	
	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", AdminName=" + AdminName + ", PassWord=" + PassWord + ", CreatName=" + CreatName
				+ ", LoginNames=" + LoginNames + ", LastTime=" + LastTime + ", Status=" + Status + "]";
	}
	
}

