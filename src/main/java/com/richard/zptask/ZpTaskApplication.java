package com.richard.zptask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Zenith Pay - Middleware Task",
                description = "Middleware that simulates payment gateway",
                contact = @Contact(
                        name = "Richard Nnaji",
                        email = "richard.nnaji013@gmail.com"
                )
        )
)
public class ZpTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZpTaskApplication.class, args);
    }

}
