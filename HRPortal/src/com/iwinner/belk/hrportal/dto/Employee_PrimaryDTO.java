package com.iwinner.belk.hrportal.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Employee_PrimaryDTO {

	private String empID;
	private String empName;
	private String empOrgName;
	private String empImgLocation;
	private String empImgType;
	private Integer empImgSize;
	private String empRole;
	private Timestamp empRegTime;
	private Date empRegDate;
	private String empComments;
	private Long empPhone;
	private String empEmail;
    private String empProjectName;
    private String empTechModule;
    private String empLocation;    
    
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpOrgName() {
		return empOrgName;
	}

	public void setEmpOrgName(String empOrgName) {
		this.empOrgName = empOrgName;
	}

	public String getEmpImgLocation() {
		return empImgLocation;
	}

	public void setEmpImgLocation(String empImgLocation) {
		this.empImgLocation = empImgLocation;
	}

	public String getEmpImgType() {
		return empImgType;
	}

	public void setEmpImgType(String empImgType) {
		this.empImgType = empImgType;
	}

	public Integer getEmpImgSize() {
		return empImgSize;
	}

	public void setEmpImgSize(Integer empImgSize) {
		this.empImgSize = empImgSize;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public Timestamp getEmpRegTime() {
		return empRegTime;
	}

	public void setEmpRegTime(Timestamp empRegTime) {
		this.empRegTime = empRegTime;
	}

	public Date getEmpRegDate() {
		return empRegDate;
	}

	public void setEmpRegDate(Date empRegDate) {
		this.empRegDate = empRegDate;
	}

	public String getEmpComments() {
		return empComments;
	}

	public void setEmpComments(String empComments) {
		this.empComments = empComments;
	}

	public Long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(Long empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	

	public String getEmpProjectName() {
		return empProjectName;
	}

	public void setEmpProjectName(String empProjectName) {
		this.empProjectName = empProjectName;
	}

	public String getEmpTechModule() {
		return empTechModule;
	}

	public void setEmpTechModule(String empTechModule) {
		this.empTechModule = empTechModule;
	}


	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	@Override
	public String toString() {
		return "Employee_PrimaryDTO [empID=" + empID + ", empName=" + empName
				+ ", empOrgName=" + empOrgName + ", empImgLocation="
				+ empImgLocation + ", empImgType=" + empImgType
				+ ", empImgSize=" + empImgSize + ", empRole=" + empRole
				+ ", empRegTime=" + empRegTime + ", empRegDate=" + empRegDate
				+ ", empComments=" + empComments + ", empPhone=" + empPhone
				+ ", empEmail=" + empEmail + ", empProjectName="
				+ empProjectName + ", empTechModule=" + empTechModule
				+ ", empLocation=" + empLocation + "]";
	}


	
}
