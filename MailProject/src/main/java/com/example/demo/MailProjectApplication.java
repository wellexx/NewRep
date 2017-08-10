package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailProjectApplication {
	
	public static void main(String[] args) {
		MailController mc= new MailController();
		SpringApplication.run(MailProjectApplication.class, args);
	}
}
