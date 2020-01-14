package pl.jwoj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main (String[] Args){

		System.out.println("Runs");
		SpringApplication.run(App.class, Args);


	}
}
