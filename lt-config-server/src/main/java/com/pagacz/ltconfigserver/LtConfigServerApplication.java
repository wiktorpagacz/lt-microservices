package com.pagacz.ltconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LtConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtConfigServerApplication.class, args);
	}

}
