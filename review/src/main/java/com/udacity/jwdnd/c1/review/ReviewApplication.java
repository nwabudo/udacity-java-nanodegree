package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

//	@Bean
//	public String message(){
//		String greeting = "Hello, Spring";
//		System.out.println("First Bean instantiated: " + greeting);
//		return greeting;
//	}
//
//	@Bean
//	public String uppercaseMessage(MessageService messageService){
//		System.out.println("Third Bean instantiated: " + messageService.uppercase());
//		return messageService.uppercase();
//	}
//
//	@Bean
//	public String lowercaseMessage(MessageService messageService){
//		System.out.println("Fourth Bean instantiated: " + messageService.lowercase());
//		return messageService.lowercase();
//	}
}
