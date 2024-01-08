package com.infy.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
