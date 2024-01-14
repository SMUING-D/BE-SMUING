package dev.umc.smuing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class 	SmuingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmuingApplication.class, args);
	}

}
