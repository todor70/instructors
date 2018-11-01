package com.zeljko.instructors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
/*@EnableAspectJAutoProxy
@ComponentScan*/
public class InstructorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructorsApplication.class, args);
	}
}
