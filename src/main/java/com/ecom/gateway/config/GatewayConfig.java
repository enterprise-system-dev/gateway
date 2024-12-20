package com.ecom.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service-api", r -> r.path("/user-service/**")
                        .uri("http://88.222.245.165:8083"))
                .route("product-api", r -> r.path("/product-service/**")
                        .uri("http://88.222.245.165:8081"))
                .route("order-payment-service", r -> r.path("/order-payment-service/**")
                        .uri("http://88.222.245.165:3000"))
                .build();
    }
}
