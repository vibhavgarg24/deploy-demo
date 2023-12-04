package com.example.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public class DemoController {
		@GetMapping("/hello")
		public String welcome() {
			return "Welcome to Deploy-demo!";
		}
	}

}
