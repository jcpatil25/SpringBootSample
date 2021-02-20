package com.omcomputers.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.omcomputers.SpringBoot.entity.Address;
import com.omcomputers.SpringBoot.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(path = "/patch/{id}", consumes = "application/json-patch+json")
	public Address updateAddress(@RequestBody JsonPatch addressPatch, @PathVariable int id) throws IllegalArgumentException, JsonProcessingException, JsonPatchException {
		Address address = addressService.applyPatchToAddress(addressPatch, id);
		return address;
	}

}
