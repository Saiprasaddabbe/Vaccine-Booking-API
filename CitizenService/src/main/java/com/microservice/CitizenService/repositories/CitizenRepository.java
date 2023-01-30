package com.microservice.CitizenService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.CitizenService.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCentreId(Integer vaccinationCentreId);

}
