package io.jsondb.spring.boot.starter;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.ICipher;
import java.util.Comparator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@EnableConfigurationProperties()
public class JsonDBAutoConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "io.jsondb.template")
    @Validated
    public JsonDBTemplateProperties jsonDBTemplateProperties() {
        return new JsonDBTemplateProperties();
    }

    @Bean
    @ConditionalOnMissingBean(JsonDBTemplate.class)
    public JsonDBTemplate jsonDBTemplate(JsonDBTemplateProperties properties, ApplicationContext applicationContext) {
        String dbFilesLocation = properties.getDbFilesLocation();
        Comparator<String> comparator = null;
        if (properties.getSchemaComparatorBean() != null) {
            comparator = applicationContext.getBean(properties.getSchemaComparatorBean(), Comparator.class);
        }
        ICipher cipher = null;
        if (properties.getCipherBean() != null) {
            cipher = applicationContext.getBean(properties.getCipherBean(), ICipher.class);
        }
        JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(
                dbFilesLocation,
                properties.getBaseScanPackage(),
                cipher,
                properties.isCompatibilityMode(),
                comparator);

        if (properties.getCollectionClassNames() != null) {
            properties.getCollectionClassNames().forEach(cn -> {
                Class<?> name;
                try {
                    name = Class.forName(cn);
                } catch (ClassNotFoundException e) {
                    throw new IllegalStateException(e);
                }
                if (!jsonDBTemplate.collectionExists(name)) {
                    jsonDBTemplate.createCollection(name);
                }
            });
        }

        return jsonDBTemplate;
    }
}
