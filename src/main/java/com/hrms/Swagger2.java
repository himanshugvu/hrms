package com.hrms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.hrms.controller")).paths(PathSelectors.any()).build()
				.pathMapping("/hrms");
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("G05", "http://www.inprocess.com", "hsuman@gmail.com");
		return new ApiInfoBuilder().title("RESTful APIs in Swagger2")
				.description("more info, pelase http://www.inprocess.com").termsOfServiceUrl("http://www.inprocess.com")
				.contact(contact).version("1.0").build();
	}
}