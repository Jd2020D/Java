package com.axsos.dojoOverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojoOverflow.models.Answer;
import com.axsos.dojoOverflow.models.Question;
import com.axsos.dojoOverflow.models.QuestionForm;
import com.axsos.dojoOverflow.services.AppService;

@Controller
public class AppController {
	 private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	 @RequestMapping("/questions")
	 public String viewQuestions(Model model) {
		 model.addAttribute("questions",this.appService.allQuestions());
	     return "questionsPage.jsp";
	 }
	 @RequestMapping("/questions/{id}")
	 public String viewQuestion(@PathVariable Long id ,Model model, @ModelAttribute("addAnswer") Answer answer) {
		 Question question=this.appService.getQuestionById(id);
		 if (question==null)
			 return "redirect:/questions";
	     model.addAttribute("question", question);
	     return "oneQuestionPage.jsp";
	 }
	 @RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
	 public String addAnswer(@PathVariable Long id ,Model model, @Valid @ModelAttribute("addAnswer") Answer answer,BindingResult result) {
		 Question question=this.appService.getQuestionById(id);
		 if (question==null)
			 return "redirect:/questions"; 
		 model.addAttribute("question",question);
		 if(result.hasErrors())
			 return "oneQuestionPage.jsp";
		 this.appService.createAnswer(answer,question);
	     return "redirect:/questions/"+question.getId().toString();
	 }
	 @RequestMapping("/questions/new")
	 public String viewQuestion(@ModelAttribute("newQuestion") QuestionForm question) {
	     return "newQuestionPage.jsp";
	 }
	 @RequestMapping(value="/questions/new", method=RequestMethod.POST)
	 public String addQuestion(@Valid @ModelAttribute("newQuestion") QuestionForm question, BindingResult result) {
	     if(result.hasErrors())
	    	 return "newQuestionPage.jsp";
	     Question question_created=this.appService.createQuestion(question);
	     return "redirect:/questions/"+question_created.getId().toString();
	 }

	 

	 


}
