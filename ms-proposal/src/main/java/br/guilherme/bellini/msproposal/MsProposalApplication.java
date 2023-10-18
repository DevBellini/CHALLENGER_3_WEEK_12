package br.guilherme.bellini.msproposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsProposalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProposalApplication.class, args);
	}

}
