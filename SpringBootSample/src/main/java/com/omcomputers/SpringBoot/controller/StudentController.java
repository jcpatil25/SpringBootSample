package com.omcomputers.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omcomputers.SpringBoot.entity.Student;
import com.omcomputers.SpringBoot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.save(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		
		return studentService.findAll();
	}

}
