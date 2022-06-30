package dd.projects.DDShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DdShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(DdShopApplication.class, args);
	}

}
