package com.scaler.ecomproductservice;

import com.scaler.ecomproductservice.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EComProductServiceApplication implements CommandLineRunner {
	
	private InitService initService;

	public EComProductServiceApplication(InitService initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EComProductServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		this.initService.initialise();
	}
}
