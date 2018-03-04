package com.airtel.report.monitor.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by sunny on 04/03/18.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.airtel.report.monitor.rest"))
                .paths(PathSelectors.ant("/app/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My Airtel Monitor REST API",
                "The API's to get unique users based on different criteria.",
                "API TOS",
                "Terms of service",
                new Contact("Sunny Verma", "www.airtel.in", "sunnyvrm8@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
