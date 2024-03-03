//package com.example.demo.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.dto.CourseDto;
//import com.example.demo.dto.StudentDto;
//import com.example.demo.repository.StudentRepository;
//
//@Component
//public class StudentDao {
//
//	@Autowired
//	StudentRepository studentRepository;
//	
//	
////	public String insertstudent(StudentDto studentDto) {
////		studentRepository.save(studentDto);
////		return "Student data saved";
////	}
//	
//
//	public String insertStundet(StudentDto studentDto) {
//		studentRepository.save(studentDto);
//		return "student info saved";
//	}
//	
//	public List<StudentDto> fetchAllStudnt() {
//		return studentRepository.findAll();
//	}
//}

package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.repository.StudentRepository;

@Component
public class StudentDao {

    @Autowired
    StudentRepository studentRepository;

    public String insertStudent(StudentDto studentDto) {
        studentRepository.save(studentDto);
        return "Student info saved";
    }

    public List<StudentDto> fetchAllStudents() {
        return studentRepository.findAll();
    }
}

