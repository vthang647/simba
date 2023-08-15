package com.simba68.sbcentralizeconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SbCentralizeConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCentralizeConfigurationApplication.class, args);
	}

}
