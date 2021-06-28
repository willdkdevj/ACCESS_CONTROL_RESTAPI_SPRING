package br.com.supernova.accesscontrol.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String API_TITLE = "REST API of Users Access Control";
    private static final String API_DESCRIPTION = "Spring Boot REST API for platform user access control in a fictitious organization";
    private static final String CONTACT_NAME = "William Derek Dias";
    private static final String CONTACT_GITHUB = "https://github.com/willdkdevj";
    private static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    private static final String CONTACT_EMAIL = "williamdkdevops@gmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(apis()) // RequestHandlerSelectors.any()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(constructorApiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                    .name("Authorization")
                                    .description("Header to Token JWT")
                                    .modelRef(new ModelRef("string"))
                                    .parameterType("header")
                                    .required(false)
                                    .build()
                        )
                );
    }

    private Predicate<RequestHandler> apis(){
        return RequestHandlerSelectors.basePackage("br.com.supernova.accesscontrol");
    }

    public ApiInfo constructorApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl(LICENSE_URL)
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
}

