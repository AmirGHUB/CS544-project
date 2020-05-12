package edu.miu.cs544.team6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class TmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmApplication.class, args);
	}

	@RestController
	public class MyController {
        @GetMapping("/")
        public String test() {
            return "working";
        }
    }

}
