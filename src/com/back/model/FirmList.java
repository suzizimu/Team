package com.back.model;

public class FirmList {

	private int ID;
	private String FirmName;
	private String FirmCode;
	private String PassWord;
	private String Type;
	private String Area;
	private String Adress;
	private String LinkMan;
	private String Tel;
	private String Email;
	private String PeopeNumber;
	private String Des;
	private String FirmID;
	private String Picture;
	private String Logo;
	private String CardStart;
	private String Status;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getFirmCode() {
		return FirmCode;
	}
	public void setFirmCode(String firmCode) {
		FirmCode = firmCode;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getLinkMan() {
		return LinkMan;
	}
	public void setLinkMan(String linkMan) {
		LinkMan = linkMan;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPeopeNumber() {
		return PeopeNumber;
	}
	public void setPeopeNumber(String peopeNumber) {
		PeopeNumber = peopeNumber;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getFirmID() {
		return FirmID;
	}
	public void setFirmID(String firmID) {
		FirmID = firmID;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getCardStart() {
		return CardStart;
	}
	public void setCardStart(String cardStart) {
		CardStart = cardStart;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", FirmName=" + FirmName + ", FirmCode=" + FirmCode + ", PassWord=" + PassWord
				+ ", Type=" + Type + ", Area=" + Area + ", Adress=" + Adress + ", LinkMan=" + LinkMan + ", Tel=" + Tel
				+ ", Email=" + Email + ", PeopeNumber=" + PeopeNumber + ", Des=" + Des + ", FirmID=" + FirmID
				+ ", Picture=" + Picture + ", Logo=" + Logo + ", CardStart=" + CardStart + ", Status=" + Status + "]";
	}
	
	
}
