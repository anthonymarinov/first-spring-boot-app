package testapp.FirstSBApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@Configuration
@ComponentScan("testapp")
public class FirstSbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSbAppApplication.class, args);
	}

}
