package com.microservice.VaccinationCenter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.VaccinationCenter.entity.VaccinationCenter;
import com.microservice.VaccinationCenter.model.Citizen;
import com.microservice.VaccinationCenter.model.RequiredResponse;
import com.microservice.VaccinationCenter.repository.VaccinationRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationRepository vRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<List<VaccinationCenter>> addVaccinationCenter(@RequestBody VaccinationCenter vc) {

		vRepo.save(vc);
		List<VaccinationCenter> list = vRepo.findAll();

		return new ResponseEntity<List<VaccinationCenter>>(list, HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id){
		
		RequiredResponse requiredResponse =  new RequiredResponse();
		VaccinationCenter vc =   vRepo.findById(id).get();
		requiredResponse.setCenter(vc);
		
		List<Citizen> citizen =   restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(citizen);
		
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
		
		
	}
	
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
		RequiredResponse requiredResponse =  new RequiredResponse();
		VaccinationCenter vc =   vRepo.findById(id).get();
		requiredResponse.setCenter(vc);
			
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
		
		
		
	}

	
	
	
	
	
}
