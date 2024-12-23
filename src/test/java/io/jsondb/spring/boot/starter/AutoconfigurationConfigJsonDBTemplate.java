package io.jsondb.spring.boot.starter;

import io.jsondb.JsonDBTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoconfigurationConfigJsonDBTemplate {

    @Bean
    public JsonDBTemplate template() {
        return new JsonDBTemplate("target/dbfiles", "io.jsondb.spring.boot.starter.model");
    }

}
