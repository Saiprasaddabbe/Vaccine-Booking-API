package com.microservice.VaccinationCenter.model;

import java.util.ArrayList;
import java.util.List;

import com.microservice.VaccinationCenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

	private VaccinationCenter center;
    private List<Citizen> citizens;
	
	
}
