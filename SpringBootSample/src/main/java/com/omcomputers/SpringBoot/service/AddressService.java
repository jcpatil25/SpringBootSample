package com.omcomputers.SpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.omcomputers.SpringBoot.dao.AddressRepository;
import com.omcomputers.SpringBoot.entity.Address;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public Address applyPatchToAddress(JsonPatch addressPatch, int id) throws IllegalArgumentException, JsonPatchException, JsonProcessingException {
		
		Optional<Address> actualAddress = addressRepository.findById(id);
		
		if(actualAddress.isPresent()) {
			
			JsonNode jsonNode = addressPatch.apply(objectMapper.convertValue(actualAddress.get(), JsonNode.class));
			Address address = objectMapper.treeToValue(jsonNode, Address.class);
			return address;
		}
		return null;
	}

	
}
