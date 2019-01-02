package io.pivotal.cloudnativespring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
@RestController
public class CloudNativeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeSpringApplication.class, args);
	}

	@Value("${greeting:Hola}")
	private String greeting;

	@RequestMapping("/")
	public String hello() {
		return greeting + " World!";
	}
}

