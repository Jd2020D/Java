package com.axsos.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HumanController {
	@RequestMapping("")
    public String root(@RequestParam(value="name", required=false) String name,@RequestParam(value="first_name", required=false) String firstName,@RequestParam(value="last_name", required=false) String LastName) {
       String welcome="<p>Welcome to SpringBoot!</p>";
       if (firstName!=null && LastName!=null)
    	   return "<h1>Hello " + firstName+" "+LastName+" !</h1>"+welcome;
       if(name != null && firstName==null && LastName!=null)
    	   return "<h1>Hello " + name+" "+LastName+" !</h1>"+welcome;
       if(name != null)
    	   return "<h1>Hello " + name+" !</h1>"+welcome;
       else if(firstName != null)
    	   return "<h1>Hello " + firstName+" !</h1>"+welcome;
       else if(LastName != null)
    	   return "<h1>Hello " + LastName+" !</h1>"+welcome;
       else
    	   return "<h1>Hello Human" +" !</h1>"+welcome;

       
    }
}
