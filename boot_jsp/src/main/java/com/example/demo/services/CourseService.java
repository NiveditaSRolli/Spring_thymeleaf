package com.example.demo.services;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.dto.CourseDto;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	public String insertCourse(CourseDto courseDto) {
		return courseDao.insertCourse(courseDto);
	}


public CourseDto fetchCourseByPk(String cname) {
	 java.util.Optional<CourseDto> cd=courseDao.fetchCourseByPk(cname);
	if(cd.isEmpty())
	{
		return null;
	}
	else
	{
		return cd.get();
	}
}}