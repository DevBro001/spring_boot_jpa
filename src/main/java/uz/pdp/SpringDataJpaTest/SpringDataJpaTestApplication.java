package uz.pdp.SpringDataJpaTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTestApplication.class, args);
	}

//	@Bean
	public CommandLineRunner insertQuery(DataSource dataSource){
		return args->{
			Resource resource = new ClassPathResource("query.sql");
			System.out.println("=================================================================");
			ScriptUtils.executeSqlScript(dataSource.getConnection(),resource);
		};
	}
	@Bean
	public AuditorAware<Integer> auditorAware(){
		return ()-> Optional.ofNullable(new Random().nextInt());
	}
}
