package com.microservice.VaccinationCenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Citizen {


	private Integer id;

	private String name;

	private Integer vaccinationCentreId;
	
	
}
