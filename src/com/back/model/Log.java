package com.back.model;

public class Log {
     
	private int ID;
	private String AdminName;
	private String Type;
	private String Operate;
	private String OperateDate;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getOperate() {
		return Operate;
	}
	public void setOperate(String operate) {
		Operate = operate;
	}
	public String getOperateDate() {
		return OperateDate;
	}
	public void setOperateDate(String operateDate) {
		OperateDate = operateDate;
	}
	@Override
	public String toString() {
		return "Log [ID=" + ID + ", AdminName=" + AdminName + ", Type=" + Type + ", Operate=" + Operate
				+ ", OperateDate=" + OperateDate + "]";
	}
	
	
}
