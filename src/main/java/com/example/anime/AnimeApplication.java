package com.example.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableFeignClients
@SpringBootApplication
public class AnimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeApplication.class, args);
	}

}
