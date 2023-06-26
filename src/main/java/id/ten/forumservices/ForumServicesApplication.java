package id.ten.forumservices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@OpenAPIDefinition
@EnableAsync
public class ForumServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumServicesApplication.class, args);
    }
}
