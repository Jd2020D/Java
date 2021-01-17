package com.axsos.worldProject.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axsos.worldProject.models.City;

public interface CityRepository extends CrudRepository<City, Long>{
	List<City>findAll();
	
//	List<City>findAllById(Set<Long> Ids);// correct
	@Query(value="SELECT city.* From world.countries country INNER join world.cities city ON city.country_id=country.id where country.name='Mexico' and city.population>=500000 order by city.population desc",nativeQuery = true)
	List<City> getMexicoCitiesWithPopulationGreaterThan500Thousand();
	@Query(value="SELECT country.name as countryName ,city.name as cityName ,city.district,city.population From world.countries country INNER join world.cities city ON city.country_id=country.id where country.name='Argentina' and city.population>=500000 and city.district='Buenos Aires'",nativeQuery = true)
	List<Object[]> getArgentinaCities();
	@Query(value="SELECT country.region,count(country.name) as NumOfcountriesInRegion From world.countries country group by country.region",nativeQuery = true)
	List<Object[]> NumOfcountriesInEachRegion();
}
