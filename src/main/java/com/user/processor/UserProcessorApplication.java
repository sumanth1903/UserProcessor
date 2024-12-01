package com.user.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
public class UserProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProcessorApplication.class, args);
	}

}
