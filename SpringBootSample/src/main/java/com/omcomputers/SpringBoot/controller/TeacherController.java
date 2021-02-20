package com.omcomputers.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omcomputers.SpringBoot.entity.Teacher;
import com.omcomputers.SpringBoot.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@GetMapping("/all")
	public List<Teacher> getAllTeachers() {

		System.out.println("------- List of teacher -----");

		return teacherService.findAll();
	}

	@PostMapping
	public Teacher addTeacher(@RequestBody Teacher t) {

		Teacher teacher = teacherService.save(t);
		return teacher;
	}

	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		return teacherService.findById(id);
	}

	@GetMapping("/mob/{mobNo}")
	public Teacher getTeacherByMobNo(@PathVariable String mobNo) {

		return teacherService.findByMobNo(mobNo);
	}

	@PutMapping
	public Teacher updateTeacher(@RequestBody Teacher teacher) {

		return teacherService.save(teacher);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		if (teacherService.deleteById(id))
			return "Deleted successfuly";
		return "Record not found !";
	}

}
