package com.microservice.VaccinationCenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VaccinationCenter {

	@Id
	private Integer id;
	private String centerName;
	private String  centerAddress;
	
	
	
	
	
	
}
