//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.demo.dto.CourseDto;
//import com.example.demo.dto.StudentDto;
//import com.example.demo.services.CourseService;
//import com.example.demo.services.StudentService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//
//
//@Controller
//public class StudentController {
//	
//	@Autowired
//	StudentService stundetService;
//	
//	@Autowired
//	CourseService courseService;
//
//		@GetMapping("/s")
//		public String hstml() {
//			return "student.html";
//		}
//
////		@PostMapping("/sinsert")
////		@ResponseBody
////		public String insertstudent(@ModelAttribute StudentDto studentDto) {
////			// System.out.println(courseDto);
////			return stundetService.insertstudent(studentDto);
////		}
//		
//		@PostMapping("/sinsert")
//		@ResponseBody
//		public String insertstudent(@ModelAttribute StudentDto studentDto) {
//			
//			System.out.println(studentDto);
//			String cname=studentDto.getCname();
//			CourseDto courseDto=courseService.fetchCourseByPk(cname);
//			studentDto.setCourseDto(courseDto);
//			System.out.println(studentDto);
//			return stundetService.insertstudent(studentDto);
//		}
//	
//		@GetMapping("/fasd")
//	public String fetchAllStudents(ModelMap map)
//	{
//		List<StudentDto> list=stundetService.fetchAllStudnt();
//		map.put("objects", list);
//		return "fetchAll.html";
//	}
//		
//		
//		
//}





package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.services.CourseService;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("/s")
    public String showStudentForm() {
        return "student.html";
    }

//    @PostMapping("/sinsert")
//    @ResponseBody
//    public String insertStudent(@ModelAttribute StudentDto studentDto) {
//        String cname = studentDto.getCname();
//        CourseDto courseDto = courseService.fetchCourseByPk(cname);
//        studentDto.setCourseDto(courseDto);
//        return studentService.insertstudent(studentDto);
//    }

    @PostMapping("/sinsert")
    public ResponseEntity<String> insertStudent(@RequestBody StudentDto studentDto) {
        try {
            String cname = studentDto.getCname();
            CourseDto courseDto = courseService.fetchCourseByPk(cname);
            studentDto.setCourseDto(courseDto);
            String result = studentService.insertstudent(studentDto);
            return ResponseEntity.ok(result);
        } catch (DataIntegrityViolationException e) {
            // Constraint violation exception occurred
            String errorMessage = "Error: Duplicate entry detected. This student already exists.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        } catch (Exception e) {
            // Other unexpected exceptions
            String errorMessage = "An unexpected error occurred while processing the request.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/fetchAllStudents")
    public String fetchAllStudents(ModelMap map) {
        List<StudentDto> list = studentService.fetchAllStudnt();
        map.put("objects", list);
        return "fetchAll.html";
    }
}

