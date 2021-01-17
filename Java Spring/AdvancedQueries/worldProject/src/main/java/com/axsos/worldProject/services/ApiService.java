package com.axsos.worldProject.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.axsos.worldProject.models.City;
import com.axsos.worldProject.models.Country;
import com.axsos.worldProject.models.Language;
import com.axsos.worldProject.repositories.CityRepository;
import com.axsos.worldProject.repositories.CountryRepository;
import com.axsos.worldProject.repositories.LanguageRepository;

@Service
public class ApiService {
	private final CityRepository cityRepository;
	private final CountryRepository countryRepository;
	private final LanguageRepository languageRepository;
	public ApiService(CityRepository cityRepository, CountryRepository countryRepository,
			LanguageRepository languageRepository) {
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.languageRepository = languageRepository;
	}
	public List<City> getMexicanCities(){
		return this.cityRepository.getMexicoCitiesWithPopulationGreaterThan500Thousand();
	}
	public List<City> allCities(){
		return this.cityRepository.findAll();
	}
	public List<Map<String, String>> countriesSpeaksSlovene(){
		return this.countryRepository.countriesSpeaksSlovene();
	}
	public List<Map<String, String>> numOfcities(){
		return this.countryRepository.getofNumCitesforEachCountry();
	}
	public List<Language>getLangs() {
		return this.languageRepository.languagesThatHas89Percentage();
	}
	public List<Country> SurfaceAreaBelow501(){
		return this.countryRepository.getCountriesWithSurfaceAreaBelow501AndPopluationGreaterThan100Thousand();
	}
	
	
}
