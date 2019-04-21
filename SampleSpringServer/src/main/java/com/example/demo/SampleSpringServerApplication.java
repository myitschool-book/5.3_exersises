package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SampleSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringServerApplication.class, args);
	}

}
