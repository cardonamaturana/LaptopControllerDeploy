package com.example.OpenBootcampCrudApiRest.config;


//Confirguracion Swagger para la documentacion de la API REST

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails()
    {
        return new ApiInfo("Spring boot API REST laptop",
                "aqui se crea un CRUD laptos API REST",
                "1.0",
                "http://www.google.com",
                new Contact("Julio Cardona","http://www.google.com","cardona.maturana@gmail.com"),
                "MIT",
                "http://www.google.com",
                Collections.EMPTY_LIST);
    }
}
