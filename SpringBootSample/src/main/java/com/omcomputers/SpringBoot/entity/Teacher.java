package com.omcomputers.SpringBoot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {

	@Id
	@Column(name = "teacherId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column
	String fname;

	@Column
	String lname;

	@Column
	String mobNo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", orphanRemoval = true)
	List<Address> addresses;

}
