package com.microservice.producerservie;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        System.out.println("Docket Post API");
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
        return docket;
    }

    private Predicate<String> postPaths() {
        System.out.println("Post paths");
        return or(regex("/publish"), regex("/publish"));
    }

    private ApiInfo apiInfo() {
        System.out.println("Api info");
        return new ApiInfoBuilder().title("Producer Service")
                .description("Producer Service API reference for developers")
                .termsOfServiceUrl("http://localhost:8080")
                .contact("haribabupacharla@gmail.com").license("Self License")
                .licenseUrl("haribabupacharla@gmail.com").version("1.0").build();
    }
}