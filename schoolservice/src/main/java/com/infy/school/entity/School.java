package com.infy.school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schoolId;
	private String schoolName;
	private String schoolAddress;
	private Long collegeId;
	
	public School() {}

	public School(Long schoolId, String schoolName, String schoolAddress, Long collegeId) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.collegeId = collegeId;
	}
	
	public School(String schoolName, String schoolAddress, Long collegeId) {
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.collegeId = collegeId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
				+ ", collegeId=" + collegeId + "]";
	}
	
	

}
