package com.back.model;

public class Resume {
      private int ID;
      private int Stu_ID;
      private String FirmName;
      private String Resume;
      private String Major;
      private String RealName;
      private String EducationBgd;
      private String Intention;
      private String ResumeTime;
      
  	  private int RecruitID;
      private String Job;
      
	public int getRecruitID() {
		return RecruitID;
	}
	public void setRecruitID(int recruitID) {
		RecruitID = recruitID;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getStu_ID() {
		return Stu_ID;
	}
	public void setStu_ID(int stu_ID) {
		Stu_ID = stu_ID;
	}
	public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getResume() {
		return Resume;
	}
	public void setResume(String resume) {
		Resume = resume;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public String getEducationBgd() {
		return EducationBgd;
	}
	public void setEducationBgd(String educationBgd) {
		EducationBgd = educationBgd;
	}
	public String getIntention() {
		return Intention;
	}
	public void setIntention(String intention) {
		Intention = intention;
	}
	public String getResumeTime() {
		return ResumeTime;
	}
	public void setResumeTime(String resumeTime) {
		ResumeTime = resumeTime;
	}
      
}
