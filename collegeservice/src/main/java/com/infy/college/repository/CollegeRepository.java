package com.infy.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.college.entity.College;

public interface CollegeRepository extends JpaRepository<College, Long>{

	College findByCollegeId(Long collegeId);
}
