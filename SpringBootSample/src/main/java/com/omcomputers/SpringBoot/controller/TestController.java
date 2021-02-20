package com.omcomputers.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.omcomputers.SpringBoot.dao.AddressRepository;
import com.omcomputers.SpringBoot.entity.Address;
import com.omcomputers.SpringBoot.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	AddressRepository repo;
	
	@Autowired
	TestService testService;
	
	@GetMapping
	public List<Address> test() {
		
		return repo.findAllAddress();
	}
	
	@PostMapping
	public String testPost(@RequestBody Address address) {
		repo.save(address);
		return "Post Request ";
	}
	
	@PutMapping("/test")
	public String putTest(){
		return "Put Request ";
	}
	@DeleteMapping("/test")
	public String deleteTest(){
		return "Delete Request ";
	}
	
	/*
	 * @PatchMapping( path = "/id", consumes = "application/json-patch+json") public
	 * Address patchTest(@RequestBody JsonPatch jsonPatch, @PathVariable int id )
	 * throws IllegalArgumentException, JsonProcessingException, JsonPatchException{
	 * 
	 * Address address = testService.applyPatchToAddress(jsonPatch, id); return
	 * address; }
	 */

}
