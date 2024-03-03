package com.example.demo.dao;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CourseDto;
import com.example.demo.repository.CourseRepository;

@Component
public class CourseDao {
	@Autowired
	CourseRepository courseRepo;
		
	public String insertCourse(CourseDto courseDto) {
		courseRepo.save(courseDto);
		return "course info saved";
	}
	public java.util.Optional<CourseDto> fetchCourseByPk(String cname)
	{
		java.util.Optional<CourseDto> cd=courseRepo.findById(cname);
		return cd;
	}
}
