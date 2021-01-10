package com.axsos.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.languages.models.Language;
import com.axsos.languages.services.LanguageService;

@Controller
public class LanguagesController {
	 private final LanguageService languageService;
	 
	 public LanguagesController(LanguageService languageService) {
		 this.languageService = languageService;
	 }
	 
	 
	 //● The GET /languages route should show a table of all the languages with links to edit and delete the languages; also include a form for creating new languages.
	 @RequestMapping("/languages")
	 public String index(@ModelAttribute("language") Language language,Model model) {
	     List<Language> languages = languageService.allLanguages();
	     model.addAttribute("languages", languages);
	     return "/languages/index.jsp";
	 }
	//● The POST /languages routes should create a language.
	 @RequestMapping(value="/languages", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/languages/index.jsp";
	     } else {
	         languageService.createLanguage(language);
	         return "redirect:/languages";
	     }
	 }
	 //● The GET /languages/{id} route should return the specific language and details.

	 @RequestMapping("/languages/{id}")
	 public String show(@PathVariable Long id ,Model model) {
		 Language language=languageService.findLanguageById(id);
		 if (language==null)
			 return "redirect:/languages";
	     model.addAttribute("language", language);
	     return "/languages/show.jsp";
	 }

	 //● The GET /languages/{id}/edit route should show the edit page to of a specific language

	 @RequestMapping("/languages/{id}/edit")
	 public String edit(@PathVariable("id") Long id, Model model) {
		 Language language=languageService.findLanguageById(id);
		 if(language==null)
	    	 return "redirect:/languages";
		 model.addAttribute("language", language);
	     return "/languages/edit.jsp";
	 }
	 //● The PUT /languages/{id} route should should update a language

	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		 if (result.hasErrors()) {
	         return "/languages/edit.jsp";
	     } else {
	    	 languageService.updateLanguage(language);
	         return "redirect:/languages";
	     }
	 }
	//● The DELETE /languages/{id} route should delete the specific language at that id.


	 @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	 public String destroy(@PathVariable("id") Long id) {
		 languageService.deleteLanguage(id);
		 return "redirect:/languages";
	 }


	 



}