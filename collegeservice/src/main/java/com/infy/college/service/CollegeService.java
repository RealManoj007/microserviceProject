package com.infy.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.college.entity.College;
import com.infy.college.repository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository collegeRepository;

	public College insertCollege(College college) {
		return collegeRepository.save(college);
	}

	public College findCollegeById(Long collegeId) {
		return collegeRepository.findByCollegeId(collegeId);
	}

}
