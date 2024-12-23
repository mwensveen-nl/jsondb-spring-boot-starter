package io.jsondb.spring.boot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.jsondb")
public class AutoConfigurationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationApplication.class, args);
    }
}