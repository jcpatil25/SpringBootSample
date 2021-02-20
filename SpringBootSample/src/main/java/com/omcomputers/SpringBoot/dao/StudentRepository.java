package com.omcomputers.SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omcomputers.SpringBoot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(" From Student")
	List<Student> findAllStudents();

}
