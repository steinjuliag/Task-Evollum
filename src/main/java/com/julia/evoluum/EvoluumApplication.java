package com.julia.evoluum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EvoluumApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoluumApplication.class, args);
	}

}
