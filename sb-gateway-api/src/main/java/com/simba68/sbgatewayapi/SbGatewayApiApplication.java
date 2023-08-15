package com.simba68.sbgatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SbGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbGatewayApiApplication.class, args);
	}

}
