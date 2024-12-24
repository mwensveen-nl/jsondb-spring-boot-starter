package io.jsondb.spring.boot.starter;

import io.jsondb.JsonDBConfig;
import io.jsondb.JsonDBTemplate;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.ReflectionUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = { JsonDBAutoConfiguration.class })
@TestPropertySource(value = "classpath:application-empty.yml", factory = YamlPropertySourceFactory.class)
class JsondbAutoConfigurationEmptyYmlTest {

    @Autowired
    private JsonDBTemplateProperties properties;

    @Autowired
    private JsonDBTemplate template;

    @Test
    void autoConfigTest() throws IllegalArgumentException, IllegalAccessException {
        assertNotNull(properties);
        assertEquals("target/dbfiles", properties.getDbFilesLocation());
        assertEquals("io.jsondb.spring.boot.starter.model", properties.getBaseScanPackage());
        assertFalse(properties.isCompatibilityMode());
        assertNull(properties.getSchemaComparatorBean());
    }

    @Test
    void autoConfigTemplateTest() throws IllegalArgumentException, IllegalAccessException {
        Field field = ReflectionUtils.findField(JsonDBTemplate.class, "dbConfig");
        ReflectionUtils.makeAccessible(field);
        JsonDBConfig config = (JsonDBConfig) field.get(template);
        assertEquals("target/dbfiles", config.getDbFilesLocationString());
        assertEquals("io.jsondb.DefaultSchemaVersionComparator", config.getSchemaComparator().getClass().getName());

    }

}
