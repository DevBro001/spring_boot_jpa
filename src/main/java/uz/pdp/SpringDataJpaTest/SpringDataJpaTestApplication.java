package uz.pdp.SpringDataJpaTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.nio.ByteBuffer;

@SpringBootApplication
public class SpringDataJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return (args)->{
				userService.m1();

		};
	}

}
