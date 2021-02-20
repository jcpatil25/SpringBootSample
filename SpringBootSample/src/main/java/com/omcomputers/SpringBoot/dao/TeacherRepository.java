package com.omcomputers.SpringBoot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.omcomputers.SpringBoot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	Teacher findByMobNo(String mobNo);

	boolean existsByFname(String fname);

	@Transactional
	@Modifying
	@Query(" delete from Teacher t WHERE t.fname = ?1")
	void deleteByFname(String fname);

	Optional<Teacher> findByFname(String fname);

}
