package infin_bank.interview.figure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FigureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigureApplication.class, args);
	}

}
