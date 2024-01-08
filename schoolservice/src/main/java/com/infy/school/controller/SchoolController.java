package com.infy.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.school.dto.College;
import com.infy.school.dto.ResponseData;
import com.infy.school.dto.SchoolData;
import com.infy.school.entity.School;
import com.infy.school.service.SchoolService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/school")
@Slf4j
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/home")
	public String getHome() {
		return "This is School API";
	}
	
	@GetMapping("/{schoolId}")
	public ResponseEntity<ResponseData> getCollege(@PathVariable Long schoolId){
		
		ResponseData responseData = new ResponseData();
		
		School s=new School(1L,"SchoolPne","PKLCHD",1L);
		
		responseData.setSchool(s);
		
		Long collegeId=s.getCollegeId();
		RestTemplate restTemplate = new RestTemplate();
		String endPointUrl="http://localhost:8081/college/{collegeId}";
		
		ResponseEntity<College> data=restTemplate
				.getForEntity(endPointUrl, College.class,collegeId);
		
				
		if(data.getStatusCode()==HttpStatus.OK) {
			College clg = data.getBody();
			responseData.setCollege(clg);
		}
		
		return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK);
	}
	
	@PostMapping("/addSchool")
	public ResponseEntity<School> saveSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
	}
	
	@GetMapping("/getSchool/{id}")
	@CircuitBreaker(name = "getSchoolBreaker",fallbackMethod = "getSchoolFallBack")
	public ResponseEntity<SchoolData> getSchool(@PathVariable Long id) {
		return new ResponseEntity<SchoolData>( schoolService.getSchoolById(id),HttpStatus.OK);
	}	
	
	public ResponseEntity<SchoolData> getSchoolFallBack(Long Id, Exception ex){
		log.info("Fallback is executed because service is down", ex.getMessage());
		College c=new College("TestBreadker College","TestBreaker Address");
		SchoolData sd=new  SchoolData(1L,"TestBreaherBySchool","Test",1L,c);
		return new ResponseEntity<SchoolData>(sd,HttpStatus.OK);
	}
	
}