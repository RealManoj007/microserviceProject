package com.infy.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.college.entity.College;
import com.infy.college.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;

	@GetMapping("/home")
	public String getHome() {
		return "This is College API";
	}
	
	@GetMapping("/{collegeId}")
	public ResponseEntity<College> getCollege(@PathVariable Long collegeId){
		College c=new College(1L,"Army College","CHD");
		return new ResponseEntity<College>(c,HttpStatus.OK);
	}
	
	@PostMapping("/addcollege")
	public ResponseEntity<College> saveCollege(@RequestBody College college) {
		College insertCollege = collegeService.insertCollege(college);
		return new ResponseEntity<College>(insertCollege,HttpStatus.OK);
	}
	
	@GetMapping("/find/{collegeId}")
	public ResponseEntity<College> getCollegeById(@PathVariable Long collegeId){
		 College findCollegeById = collegeService.findCollegeById(collegeId);
		 return new ResponseEntity<College>(findCollegeById,HttpStatus.OK);
	}
}
