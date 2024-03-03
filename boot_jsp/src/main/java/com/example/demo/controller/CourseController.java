package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CourseDto;
import com.example.demo.services.CourseService;


@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/c")
	public String chtml() {
		return "course.html";
	}

	@PostMapping("/cinsert")
	@ResponseBody
	public String insertCourse(@ModelAttribute CourseDto courseDto) {
		// System.out.println(courseDto);
		return courseService.insertCourse(courseDto);
	}
}