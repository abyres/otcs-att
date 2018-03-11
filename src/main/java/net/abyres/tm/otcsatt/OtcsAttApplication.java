package net.abyres.tm.otcsatt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("net.abyres.tm.otcs.model")
@SpringBootApplication
public class OtcsAttApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtcsAttApplication.class, args);
	}
}
