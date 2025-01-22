package com.dimas.gateway.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springdoc.core.GroupedOpenApi;

@Configuration
public class OpenAPIGatewayConfig {

    @Bean
    public GroupedOpenApi customerApi() {
        return GroupedOpenApi.builder()
                .group("customers")
                .pathsToMatch("/api/v1/customers/**")
                .build();
    }

    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder()
                .group("products")
                .pathsToMatch("/api/v1/products/**")
                .build();
    }

    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder()
                .group("orders")
                .pathsToMatch("/api/v1/orders/**")
                .build();
    }

    @Bean
    public GroupedOpenApi paymentApi() {
        return GroupedOpenApi.builder()
                .group("payments")
                .pathsToMatch("/api/v1/payments/**")
                .build();
    }

    @Bean
    public GroupedOpenApi notificationApi() {
        return GroupedOpenApi.builder()
                .group("notifications")
                .pathsToMatch("/api/v1/notifications/**")
                .build();
    }
}
