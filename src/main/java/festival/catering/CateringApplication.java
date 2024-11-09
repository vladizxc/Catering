package festival.catering;

import org.salespointframework.EnableSalespoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSalespoint
@SpringBootApplication
public class CateringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CateringApplication.class, args);
	}

}
