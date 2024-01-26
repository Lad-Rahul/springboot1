package com.springboot1.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

//This java class is entry point of springBoot application
//It will by default run on embadded tomcat server at port 8080

/* below annotation  combination of 3 different annotation add configuration, 
   add/enable auto configuration and addComponentScan
*/
@SpringBootApplication
@ComponentScan({ "com.springboot1.controller", "com.springboot1.service"})
@EntityScan("com.springboot1.entity")
@EnableJpaRepositories("com.springboot1.repository")
@EnableScheduling
public class Springboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot1Application.class, args);

	}

}
