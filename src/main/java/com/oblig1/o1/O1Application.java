package com.oblig1.o1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.oblig.o1", "com.oblig1.o1.controllers", "com.oblig.o1.models"})
public class O1Application {

	public static void main(String[] args) {
		SpringApplication.run(O1Application.class, args);
	}
}
