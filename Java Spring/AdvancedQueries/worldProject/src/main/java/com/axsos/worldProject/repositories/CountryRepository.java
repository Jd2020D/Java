package com.axsos.worldProject.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axsos.worldProject.models.Country;
//name,language,percentage
public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query(value="SELECT   c.name as country,l.language as language ,l.percentage as percentage FROM world.countries c INNER JOIN  world.languages  l  ON l.country_id = c.id    where language='Slovene'",nativeQuery=true)
	List<Map<String, String>> countriesSpeaksSlovene();
	@Query(value="SELECT   country.name as country,count(city.name) as NumOfCities FROM        world.countries country INNER JOIN  world.cities  city ON      city.country_id = country.id group by country.name order by count(city.name)",nativeQuery=true)
	List<Map<String, String>> getofNumCitesforEachCountry();
//	@Query(value="SELECT * from countries country where country.surface_area<=501 and country.population>=100000",nativeQuery = true)
	@Query(value="SELECT * From countries",nativeQuery = true)
	List<Country> getCountriesWithSurfaceAreaBelow501AndPopluationGreaterThan100Thousand();
	@Query(value="SELECT country.* from countries country where country.surface_area>=200 and country.government_form='Constitutional Monarchy' and country.life_expectancy>=75",nativeQuery = true)
	List<Object[]> getConstitutionalCountriesWith();
}
