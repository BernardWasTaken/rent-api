package com.example.rentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentApiApplication {

	public static void main(String[] args) {
		baseConnection bc = new baseConnection();
		bc.connect();
		SpringApplication.run(RentApiApplication.class, args);
	}

}
