package com.axsos.worldProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axsos.worldProject.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	@Query(value="SELECT language.* From world.countries country INNER join world.languages language ON language.country_id=country.id where language.percentage>89 order by language.percentage desc",nativeQuery=true)
	List<Language> languagesThatHas89Percentage();
}
