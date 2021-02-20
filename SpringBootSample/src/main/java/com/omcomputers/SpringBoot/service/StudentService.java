package com.omcomputers.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omcomputers.SpringBoot.dao.StudentRepository;
import com.omcomputers.SpringBoot.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public Student save(Student student) {
		
		return repository.save(student);
	}

	public List<Student> findAll() {

		return repository.findAllStudents();
	}

}
