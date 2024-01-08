package com.infy.school.dto;

import com.infy.school.entity.School;

public class ResponseData {

	private School school;
	private College college;
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "ResponseData [school=" + school + ", college=" + college + "]";
	}
}
