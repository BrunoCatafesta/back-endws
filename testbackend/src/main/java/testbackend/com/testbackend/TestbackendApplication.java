package testbackend.com.testbackend;

import com.testbackend.enun.EnumStatusOrdered;
import com.testbackend.persistence.StatusOrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Collections;

@SpringBootApplication
@ComponentScan({"com.testbackend"})
@EntityScan(basePackages = "com.testbackend.entity")
@EnableSwagger2
public class TestbackendApplication {

	@Autowired
	private StatusOrderedRepository statusOrderedRepository;

	@PostConstruct
	public void persistStatusOrdered(){
        EnumStatusOrdered.getAllStatus()
        	.forEach(status -> statusOrderedRepository
        	.mergeOrPersist(status));
	}

	public static void main(String[] args) {
		SpringApplication.run(TestbackendApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build().apiInfo(getApiInfo());
	}
	
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "Desafio Wealth Systems",
	            "Desafio Wealth Systems para back-end",
	            "0.0.1-SNAPSHOT",
	            "",
	            new Contact("Bruno Catafesta","URL","alex.bruno4@gmail.com"),
	            "Catafesta",
	            "",
	            Collections.emptyList()
	    );
	}
}