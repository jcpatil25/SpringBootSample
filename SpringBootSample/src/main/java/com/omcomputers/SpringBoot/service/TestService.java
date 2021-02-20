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
public class TestService {
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ObjectMapper objectMapper;

	public Address applyPatchToAddress(JsonPatch jsonPatch, int id) throws IllegalArgumentException, JsonPatchException, JsonProcessingException {

		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent()) {
			JsonNode jsonNode = jsonPatch.apply(objectMapper.convertValue(address, JsonNode.class));
			Address address2 = objectMapper.treeToValue(jsonNode, Address.class);
			return address2;
		}
		return null;
	}

}
