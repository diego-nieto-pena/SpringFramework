package com.security.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.security.commons.entity"})
public class SecurityUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityUserServiceApplication.class, args);
	}

}
