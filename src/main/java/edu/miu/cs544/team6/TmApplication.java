package edu.miu.cs544.team6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmApplication.class, args);
		// Test
	}

}
