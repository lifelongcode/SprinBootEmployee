package com.abrahamspw.springhwone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class SpringhwoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhwoneApplication.class, args);
	}

}
