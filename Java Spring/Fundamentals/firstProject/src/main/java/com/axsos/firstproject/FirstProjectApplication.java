package com.axsos.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstProjectApplication {
        public static void main(String[] args) {
                SpringApplication.run(FirstProjectApplication.class, args);
        }
        
        @RequestMapping("/")
        public String hello() { 
                return "<h1>Hello client! How are you doing?</h1>";
        }
        @RequestMapping("/random")
        public String randomPage() {
                return "<h1>Spring Boot is great! so easy to just respond with strings</h1>";
        }
}
