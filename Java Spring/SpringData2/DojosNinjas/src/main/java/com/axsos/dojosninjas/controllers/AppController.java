package com.axsos.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.services.AppService;

@Controller

public class AppController {
	 private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	 // view create dojo form
	 @RequestMapping("dojos/new")
	 public String viewNew(@ModelAttribute("dojo") Dojo dojo) {
	     return "newDojo.jsp";
	 }
	 // create dojo
	 @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "newDojo.jsp";
	     } else {
	         this.appService.createDojo(dojo);
	         return "redirect:/ninjas/new";
	     }
	 }
	 // view ninjas form

	 @RequestMapping("ninjas/new")
	 public String viewNew(@ModelAttribute("ninja") Ninja ninja,Model model) {
		 model.addAttribute("dojos",this.appService.allDojos());
	     return "newNinja.jsp";
	 }
	 // create ninja

	 @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
		 if (result.hasErrors()) {
			 model.addAttribute("dojos",this.appService.allDojos());
	         return "newNinja.jsp";
	     } else {
	    	 if(!this.appService.isDojoExist(ninja.getDojo().getId()))
	    		 return "redirect:/ninjas/new";
	         this.appService.createNinja(ninja);
	         return "redirect:/dojos/"+ninja.getDojo().getId();
	     }
	 }
	 //view dojo info
	 @RequestMapping("/dojos/{id}")
	 public String show(@PathVariable Long id ,Model model) {
		 Dojo dojo=this.appService.getDojoById(id);
		 if (dojo==null)
			 return "redirect:/dojos/new";
	     model.addAttribute("dojo", dojo);
	     return "dojoPage.jsp";
	 }



}
