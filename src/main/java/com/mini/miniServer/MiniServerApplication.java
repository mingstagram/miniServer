package com.mini.miniServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MiniServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniServerApplication.class, args);
	}

}
