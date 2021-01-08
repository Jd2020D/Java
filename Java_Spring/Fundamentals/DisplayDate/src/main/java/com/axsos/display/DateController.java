package com.axsos.display;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	
	public static String getMonthName(int month) {
	    return new DateFormatSymbols().getMonths()[month];
	}
	public static String getDayName(int day) {
	    return new DateFormatSymbols().getWeekdays()[day+1];
	}
    @RequestMapping("/")
    public String root() {
    	return "index.jsp";
    }
    @RequestMapping("/{any}")
    public String nothing(@PathVariable String any) {
    	return "redirect:/";
    }
    @RequestMapping("/date")
    public String viewDate(Model model) {
    	java.util.Date date=new java.util.Date();  
    	model.addAttribute("date", getDayName(date.getDay())+", the "+date.getDate()+" of "+getMonthName(date.getMonth())+", "+(date.getYear()+1900));
        return "date.jsp";
}    
    @RequestMapping("/time")
    public String viewtime(Model model) {
    	java.util.Date date=new java.util.Date();  
    	SimpleDateFormat df=new SimpleDateFormat("h:mm a");
    	model.addAttribute("time", df.format(date));
        return "time.jsp";
}    

}
