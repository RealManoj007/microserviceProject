package com.infy.school.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.school.dto.College;
import com.infy.school.dto.SchoolData;
import com.infy.school.entity.School;
import com.infy.school.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<School> addSchool(School school) {
		
		return new ResponseEntity<School>(schoolRepository.save(school),HttpStatus.OK);
	}

	public SchoolData getSchoolById(Long id) {
		
		String url="http://localhost:8081/college/find/{id}";
		
		College collegeObject = restTemplate.getForObject(url, College.class,id);
		
		School school = schoolRepository.findById(id).get();
		
		SchoolData schoolData=new SchoolData();
		
		BeanUtils.copyProperties(school, schoolData);
		
		schoolData.setCollege(collegeObject);
		
		return schoolData;
	}

}
