package com.axsos.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	 private final LanguageRepository languageRepository;
	 
	 public LanguageService(LanguageRepository languageRepository) {
	     this.languageRepository = languageRepository;
	 }
	 public List<Language> allLanguages(){
		 return this.languageRepository.findAll();
	 }
	 public Language createLanguage(Language lang) {
		 return this.languageRepository.save(lang);
	 }
	 public Language findLanguageById(Long id) {
		 Optional<Language> lang= this.languageRepository.findById(id);
		 if  (lang.isPresent())
			 return lang.get();
		 return null;
	 }
	 public Language updateLanguage(Language language) {
		 Language lang=this.findLanguageById(language.getId());
		 if(lang!=null) 
			 return this.languageRepository.save(language);
		 return null;
	 }
	 public boolean deleteLanguage(Long id) {
		 if (id != null)
			 if(this.languageRepository.existsById(id)) {
				 this.languageRepository.deleteById(id);
				 return true;
			 }
		 return false;
	 }
}
