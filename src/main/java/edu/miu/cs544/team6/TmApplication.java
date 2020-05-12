package edu.miu.cs544.team6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger(TmApplication.class);
	public static void main(String[] args) {
	    LOGGER.info("started the application");
		SpringApplication.run(TmApplication.class, args);
	}

	@RestController
	public class MyController {
        @GetMapping("/")
        public String test() {
            return "it's working";
        }
    }

}
