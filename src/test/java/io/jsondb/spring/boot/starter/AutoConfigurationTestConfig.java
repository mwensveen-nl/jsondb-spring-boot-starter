package io.jsondb.spring.boot.starter;

import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;
import io.jsondb.spring.boot.starter.model.MySchemaVersionComparator;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Comparator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfigurationTestConfig {

    @Bean(name = "MySchemaVersionComparator")
    public Comparator<String> mySchemaVersionComparator() {
        return new MySchemaVersionComparator();
    }

    @Bean(name = "MyCipher")
    public ICipher myCipher() throws GeneralSecurityException {
        return new Default1Cipher(Base64.getEncoder().encode("abc".getBytes()));
    }
}
