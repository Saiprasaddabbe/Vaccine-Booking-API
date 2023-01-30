package com.microservice.CitizenService.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.CitizenService.entity.Citizen;
import com.microservice.CitizenService.repositories.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CititzenController {

	@Autowired
	private CitizenRepository cRepo;

	@RequestMapping(path = "/test")
	public ResponseEntity<String> test() {

		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}

	@RequestMapping(path = "/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
		
		List<Citizen> list = cRepo.findByVaccinationCentreId(id);
		
		return new ResponseEntity<List<Citizen>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<Citizen>> addCitizen(@RequestBody Citizen citizen){
		
		   cRepo.save(citizen);
		   List<Citizen> list =  cRepo.findAll();
		   
		   return new ResponseEntity<List<Citizen>>(list,HttpStatus.CREATED);
	}

}
