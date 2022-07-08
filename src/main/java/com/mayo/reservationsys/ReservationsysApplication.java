package com.mayo.reservationsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ReservationsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsysApplication.class, args);
	}

}
