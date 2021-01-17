package com.axsos.worldProject.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.worldProject.models.City;
import com.axsos.worldProject.models.Country;
import com.axsos.worldProject.models.Language;
import com.axsos.worldProject.services.ApiService;

@RestController
@RequestMapping("/query")
public class ApiController {
	private final ApiService apiService;

	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	@RequestMapping("/1")
	public List<Map<String, String>> queryResult1() {
		return this.apiService.countriesSpeaksSlovene();
	}
	@RequestMapping("/2")
	public List<Map<String, String>> queryResult2() {
		return this.apiService.numOfcities();
	}
	@RequestMapping("/3")
	public List<City> queryResult3() {
		return this.apiService.getMexicanCities();
	}
	@RequestMapping("/4")
	public List<Language> queryResult4() {
		return this.apiService.getLangs();
	}
	@RequestMapping("/5")
	public List<Country> queryResult5() {
		return this.apiService.SurfaceAreaBelow501();
	}
	
//	public List<City> Index() {
//		System.out.println(this.apiService.allCities());
//		return this.apiService.allCities();
//	}
//	
//
	
}
