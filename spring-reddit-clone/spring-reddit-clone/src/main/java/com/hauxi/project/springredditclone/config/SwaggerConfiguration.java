package com.hauxi.project.springredditclone.config;

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
public class SwaggerConfiguration {
    
    @Bean
    public Docket reddiCloneApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
        .version("1.0")
        .description("API for reddit")
        .contact(new Contact("Mayank Parihar", "hauxibuilds.com", "carl.razor.mostwanted@gmail.com"))
        .license("Apache License 2.0")
        .build();
    }
}
