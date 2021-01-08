package com.axsos.gold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GoldController {

	private static Form[]forms= {new Form("Farm", "(earns 10-20 golds)", "farm"),new Form("Cave", "(earns 5-10 golds)", "cave"),new Form("House", "(earns 2-5 golds)", "house"),new Form("Casino", "(earns/takes 0-50 golds)", "casino")};
    @RequestMapping("/{any}")
    public String nothing(@PathVariable String any) {
    	return "redirect:/";
    }

	
	@RequestMapping(value="/process_money",method=RequestMethod.POST)
	public String submit(@RequestParam String find_gold_in,RedirectAttributes redirectAttributes,HttpSession session){
        double before=(double)session.getAttribute("goldBalance");
        Random random=new Random();
        switch(find_gold_in) {
    	case "farm":
        	session.setAttribute("goldBalance", (double)session.getAttribute("goldBalance")+random.nextInt(11)+10);
        	break;
    	case "cave":
        	session.setAttribute("goldBalance", (double)session.getAttribute("goldBalance")+random.nextInt(6)+5);
        	break;
    	case "house":
        	session.setAttribute("goldBalance", (double)session.getAttribute("goldBalance")+random.nextInt(4) + 2);
        	break;
    	case "casino":
        	session.setAttribute("goldBalance", (double)session.getAttribute("goldBalance")+random.nextInt(101)-50);
        	break;
        }
        double charge=(double)session.getAttribute("goldBalance")-before;
    	java.util.Date date=new java.util.Date();  
    	SimpleDateFormat df=new SimpleDateFormat("MMMM DD yyyy h:mm a");

        if ((double)session.getAttribute("goldBalance")>before)
        	((ArrayList<Message>) session.getAttribute("messages")).add(new Message("Eearned "+charge+" golds from the "+find_gold_in+" ! "+df.format(date), "green"));
        else if ((double)session.getAttribute("goldBalance")<before)
        	((ArrayList<Message>) session.getAttribute("messages")).add(new Message("Entered a Casino and lost "+charge+" golds... Ouch ..  "+df.format(date), "red	"));
        else
        	((ArrayList<Message>) session.getAttribute("messages")).add(new Message("Entered a Casino and got Nothing! "+df.format(date), "red"));
    	return "redirect:/";
	}
	@RequestMapping("/")
	public String index(HttpSession session ,Model model){
		if(session.isNew()) {
			session.setAttribute("goldBalance",(double)0);
			session.setAttribute("messages",new ArrayList<Message>());
		}
		
		model.addAttribute("forms",forms);
		return "index.jsp";
	}



}
