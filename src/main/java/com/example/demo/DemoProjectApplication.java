package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@SpringBootApplication
public class DemoProjectApplication {
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		System.out.println("Spring boot application running in UTC timezone :" + new DateTime());
	}

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		
		SpringApplication.run(DemoProjectApplication.class, args);
	}

}
