package com.sambatech.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
@EnableScheduling
public class SambatechApplication {

	public static void main(String[] args) {
		SpringApplication.run(SambatechApplication.class, args);
	}

}