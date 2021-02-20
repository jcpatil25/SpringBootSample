package com.omcomputers.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omcomputers.SpringBoot.dao.TeacherRepository;
import com.omcomputers.SpringBoot.entity.Teacher;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	public Teacher save(Teacher teacher) {
		teacher.getAddresses().forEach(a -> {
			a.setTeacher(teacher);
		});
		return teacherRepository.save(teacher);

	}

	public Teacher findById(int id) {

		return teacherRepository.findById(id).get();
	}

	public Teacher findByMobNo(String mobNo) {

		return teacherRepository.findByMobNo(mobNo);
	}

	public boolean deleteById(int id) {
		if (teacherRepository.existsById(id)) {
			teacherRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	public boolean deleteByFName(String fname) {
		Optional<Teacher> teacher = teacherRepository.findByFname(fname);
		if (teacher.isPresent()) {
			teacher.get().getAddresses().forEach(a -> {
				a.setTeacher(teacher.get());
			});
			teacherRepository.deleteByFname(fname);
			return true;
		} else
			return false;

	}

}
