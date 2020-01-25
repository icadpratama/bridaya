package team.kasta.bridaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.TimeZone;

@EnableSwagger2
@SpringBootApplication
public class BridayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridayaApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jakarta"));
	}

	@Bean
	public Docket authentication() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("team.kasta.bridaya.controller.authentication"))
				.paths(PathSelectors.any())
				.build()
				.groupName("Authentication")
				.apiInfo(apiInfo()).directModelSubstitute(Timestamp.class, Long.class);
	}

	@Bean
	public Docket cashier() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("team.kasta.bridaya.controller.cashier"))
				.paths(PathSelectors.any())
				.build()
				.groupName("Personal Cashier")
				.apiInfo(apiInfo()).directModelSubstitute(Timestamp.class, Long.class);
	}

	@Bean
	public Docket common() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("team.kasta.bridaya.controller.common"))
				.paths(PathSelectors.any())
				.build()
				.groupName("Merchant")
				.apiInfo(apiInfo()).directModelSubstitute(Timestamp.class, Long.class);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"briDaya",
				"Prototype Aplikasi briDaya. Aplikasi untuk pemberdayaan UMKM di Indonesia.",
				"0.0.1",
				"Terms of Service",
				new Contact("Kasta Team", "www.kasta.team", "developer@kasta.team"),
				"License of API", "API license URL", Collections.emptyList());
	}
}
