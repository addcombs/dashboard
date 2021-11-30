package com.combs.dashboard.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.NoSuchAlgorithmException;

@Configuration
public class CassandraConfig {
    private final String username = "addcombs-at-712969401364";
    private final String password = "Kz3EK3atMPt6/EUM2Rf+V1pVWbHZy85e/KaFDWY/TYQ=";
    File driverConfig = new File(System.getProperty("user.dir")+"/application.conf");

    @Primary
    public @Bean
    CqlSession session() throws NoSuchAlgorithmException {
        return CqlSession.builder().
                withConfigLoader(DriverConfigLoader.fromFile(driverConfig)).
                withAuthCredentials(username, password).
                withSslContext(SSLContext.getDefault()).
                withKeyspace("combs_fam").
                build();
    }
}
