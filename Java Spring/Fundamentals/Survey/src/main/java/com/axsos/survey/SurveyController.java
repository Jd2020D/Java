package com.axsos.survey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping("/")
	public String index(){
		return "index.jsp";
	}
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String submit(@RequestParam String name,@RequestParam String dojo,@RequestParam String lang,@RequestParam String comment,HttpSession session){
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("lang", lang);
		session.setAttribute("comment", comment);
		
		if (lang.equals("Java")) {
			return "redirect:/result-java";
		}
		return "redirect:/result";
	}
	@RequestMapping("/result-java")
	public String java(HttpSession session) {
		return "java.jsp";
	}
	@RequestMapping("/result")
	public String result(HttpSession session){
		return "result.jsp";
	}
}
