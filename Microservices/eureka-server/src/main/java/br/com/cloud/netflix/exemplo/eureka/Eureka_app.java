package br.com.cloud.netflix.exemplo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka_app {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Eureka_app.class, args);
	}
}
