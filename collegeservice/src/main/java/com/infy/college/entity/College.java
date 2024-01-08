package com.infy.college.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long collegeId;
	private String collegeName;
	private String address;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(Long collegeId, String collegeName, String address) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.address = address;
	}
	public College(String collegeName, String address) {
		this.collegeName = collegeName;
		this.address = address;
	}
	public Long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", address=" + address + "]";
	}
	
	
	
}
