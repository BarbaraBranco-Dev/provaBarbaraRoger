package br.com.tech4me.pastelaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PastelariaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PastelariaApplication.class, args);
	}

}
