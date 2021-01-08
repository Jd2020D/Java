package com.axsos.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
    @RequestMapping("/{any}")
    public String nothing(@PathVariable String any) {
    	return "redirect:/";
    }

	@RequestMapping("/")
	public String index(HttpSession session){
		if(session.isNew())
			session.setAttribute("counter", 0);
		session.setAttribute("counter", (int)session.getAttribute("counter")+1);
		return "index.jsp";
	}
	@RequestMapping("/2")
	public String index2(HttpSession session){
		if(session.isNew())
			session.setAttribute("counter", 0);
		session.setAttribute("counter", (int)session.getAttribute("counter")+2);
		return "index2.jsp";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session){
		if(session.isNew())
			session.setAttribute("counter", 0);
		session.setAttribute("counter", 0);
		return "counter.jsp";
	}
	
	@RequestMapping("/counter")
	public String java(HttpSession session) {
		return "counter.jsp";
	}
	
}
