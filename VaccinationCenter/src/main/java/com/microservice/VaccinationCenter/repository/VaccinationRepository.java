package com.microservice.VaccinationCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.VaccinationCenter.entity.VaccinationCenter;

public interface VaccinationRepository extends JpaRepository<VaccinationCenter, Integer> {

	
	
	
}
