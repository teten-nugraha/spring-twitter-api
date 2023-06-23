package id.ten.forumservices.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI openAPI() {
        final String securitySchemeName = "bearerAuth";
        Contact contact = new Contact();
        contact.setEmail("teten.dev@gmail.com");
        contact.setName("Teten Nugraha");
        contact.setUrl("https://backendhero.com");

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Server URL in Local environment");

        Server productionServer = new Server();
        productionServer.setUrl("https://my-awesome-api.com");
        productionServer.setDescription("Server URL in Production environment");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Twitter Service API")
                .contact(contact)
                .version("1.0")
                .description("This API exposes endpoints for users to explore twitter api")
                .termsOfService("https://my-awesome-api.com/terms")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(
                                securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
