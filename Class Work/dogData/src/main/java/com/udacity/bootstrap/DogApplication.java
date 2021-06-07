package com.udacity.bootstrap;

import com.udacity.bootstrap.dtos.NumberValidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
public class DogApplication {

	private static final Logger log = LoggerFactory.getLogger(DogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public RestTemplateBuilder restTemplateBuilder(){
		return new RestTemplateBuilder();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate){
//		return args -> {
//			NumberValidate number = restTemplate.getForObject(
//					"https://phonevalidation.abstractapi.com/v1/?api_key=8fc31904e03746e19fba5807e6e442ff&phone=2348166302445",
//					NumberValidate.class
//			);
//			log.info(number.toString());
//		};
//	}

}
