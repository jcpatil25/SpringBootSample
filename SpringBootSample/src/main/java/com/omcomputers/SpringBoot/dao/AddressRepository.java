package com.omcomputers.SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omcomputers.SpringBoot.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	@Query(" From Address")
	List<Address> findAllAddress();

}
