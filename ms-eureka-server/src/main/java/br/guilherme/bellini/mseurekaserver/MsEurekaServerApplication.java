package br.guilherme.bellini.mseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServergit 
@SpringBootApplication
public class MsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaServerApplication.class, args);
	}

}
