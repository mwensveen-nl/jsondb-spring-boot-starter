package io.jsondb.spring.boot.starter;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.ICipher;
import java.util.Arrays;
import java.util.Comparator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
public class JsonDBAutoConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "io.jsondb.template")
    public JsonDBTemplateProperties jsonDBTemplateProperties() {
        return new JsonDBTemplateProperties();
    }

    @Bean
    @ConditionalOnMissingBean(JsonDBTemplate.class)
    public JsonDBTemplate jsonDBTemplate(JsonDBTemplateProperties properties, ApplicationContext applicationContext) {
        System.out.println("**************************");
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
        System.out.println("**************************");
        Comparator<String> comparator = null;
        if (properties.getSchemaComparatorBean() != null) {
            comparator = applicationContext.getBean(properties.getSchemaComparatorBean(), Comparator.class);
        }
        ICipher cipher = null;
        if (properties.getCipherBean() != null) {
            cipher = applicationContext.getBean(properties.getCipherBean(), ICipher.class);
        }
        return new JsonDBTemplate(properties.getDbFilesLocation(),
                properties.getBaseScanPackage(),
                cipher,
                properties.isCompatibilityMode(),
                comparator);
    }
}
