package com.axsos.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DojoController {
	@RequestMapping("{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		switch(dojo) {
		case "dojo":
			return "<h1>The dojo is awesome!</h1>";	
		case "burbank-dojo":
			return "<h1>Burbank Dojo is located in Southern California</h1>";	
		case "san-jose":
			return "<h1>SJ dojo is the headquarters</h1>";	
		default:
			return "What do you want!";
		}
	}

}
