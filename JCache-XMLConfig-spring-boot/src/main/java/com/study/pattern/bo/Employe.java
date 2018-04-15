package com.study.pattern.bo;

import java.io.Serializable;

public class Employe implements Serializable{
	
	private String userId;
	private String jobTitleName;
	private String firstName;
	private String lastName;
	private String preferredFullName;
	private String employeeCode;
	private String region;
	private String phoneNumber;
	private String emailAddress;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJobTitleName() {
		return jobTitleName;
	}
	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPreferredFullName() {
		return preferredFullName;
	}
	public void setPreferredFullName(String preferredFullName) {
		this.preferredFullName = preferredFullName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Employe [userId=" + userId + ", jobTitleName=" + jobTitleName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", preferredFullName=" + preferredFullName + ", employeeCode="
				+ employeeCode + ", region=" + region + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + "]";
	}
	
}
