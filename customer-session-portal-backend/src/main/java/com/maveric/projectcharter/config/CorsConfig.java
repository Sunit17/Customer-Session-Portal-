package com.maveric.projectcharter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList(Constants.CROSS_ORIGIN_URL));
        configuration.setAllowedMethods(Collections.singletonList(Constants.CROSS_ORIGIN_URL));
        configuration.setAllowedHeaders(Collections.singletonList(Constants.CROSS_ORIGIN_URL));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(Constants.ADD_MAPPING, configuration);

        return source;
    }
}
