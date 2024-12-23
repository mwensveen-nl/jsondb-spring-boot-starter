package io.jsondb.spring.boot.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = { JsonDBAutoConfiguration.class, AutoConfigurationTestConfig.class })
@TestPropertySource(value = "classpath:application_test.properties", factory = YamlPropertySourceFactory.class)
class JsondbAutoConfigurationTest {

    @Autowired
    private JsonDBTemplateProperties properties;

    @Test
    void autoConfigTest() {
        assertNotNull(properties);
        assertEquals("target/dbfiles", properties.getDbFilesLocation());
        assertEquals("io.jsondb.spring.boot.starter.model", properties.getBaseScanPackage());
        assertTrue(properties.isCompatibilityMode());
        assertEquals("MySchemaVersionComparator", properties.getSchemaComparatorBean());
    }

}
