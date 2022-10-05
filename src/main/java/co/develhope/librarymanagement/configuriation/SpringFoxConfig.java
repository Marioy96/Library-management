package co.develhope.librarymanagement.configuriation;

import co.develhope.librarymanagement.controller.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SpringFoxConfig {

    private static Logger logger = LoggerFactory.getLogger(SpringFoxConfig.class);

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfo("Library Management Software", "Il nostro software opera da un singolo punto" +
                        " vendita, ma permette di consultare l’inventario in maniera globale.\n" +
                        "E' software web-based, ovvero non è necessario installare alcun programma desktop , sarà possibile" +
                        " accedere via browser dai computer personali del nostro personale, come anche da smartphone o da" +
                        " tablet. Per questo motivo intendiamo iniziare con la realizzazione di un API in grado di interagire" +
                        " con il nostro database, a cui in seguito poter collegare un frontend web-based e le applicazioni mobile",
                        "1.0.0"," https://it.wikipedia.org/wiki/Licenza_MIT",//termsOfServiceUrl
                        new Contact("Team 2 Java 4 DevelHope","https://github.com/Marioy96/Library-management",""),//Contact
                        "MIT",//license
                        " https://it.wikipedia.org/wiki/Licenza_MIT",//licenseUrl
                        Collections.emptyList())).securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();





    }
    private ApiKey apiKey() {
        //logger.info("Private method 'apiKey' method called at "+ SpringFoxConfig.class +" at line#" + lineGetter);
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
       // logger.info("Private method 'securityContext' method called at "+ SpringFoxConfig.class +" at line#" + lineGetter);
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
       // logger.info("The method 'defaultAuth' method called at "+ SpringFoxConfig.class +" at line#" + lineGetter);
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}
