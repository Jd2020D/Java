package com.axsos.code;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {


    @RequestMapping("/{any}")
    public String nothing(@PathVariable String any) {
    	return "redirect:/";
    }

	@RequestMapping("/code")
	public String codePage(HttpSession session){
		if(session.getAttribute("code")!=null && (boolean)session.getAttribute("code") )
			return "code.jsp";
		else
			return "redirect:/";
	}
	
	@RequestMapping(value="/try",method=RequestMethod.POST)
	public String submit(@RequestParam String code,RedirectAttributes redirectAttributes,HttpSession session){
		if(code.equals("bushido")) {
			session.setAttribute("code", true);
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	@RequestMapping("/")
	public String index(HttpSession session){
		if(session.isNew())
			session.setAttribute("code", false);
		if(session.getAttribute("code")!=null && (boolean)session.getAttribute("code") )
			return "redirect:/code";
		return "index.jsp";
	}



}
