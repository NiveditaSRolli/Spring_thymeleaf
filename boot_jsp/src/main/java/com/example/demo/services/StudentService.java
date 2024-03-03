package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;


@Service
public class StudentService {

@Autowired
StudentDao studentDao;
	
	public String insertstudent(StudentDto studentDto) {
		return studentDao.insertStudent(studentDto);
	}
	
	public List<StudentDto> fetchAllStudnt() {
		return studentDao.fetchAllStudents();
	}
}
