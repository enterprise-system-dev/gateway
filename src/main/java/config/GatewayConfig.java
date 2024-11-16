package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("user-service-api", r -> r.path("/user-service/**")
                        .uri("http://88.222.245.165:8083"))
                .route("product-api", r -> r.path("/product-service/**")
                        .uri("http://88.222.245.165:3000"))
                .route("order-payment-service", r -> r.path("/order-payment-service/**")
                        .uri("http://88.222.245.165:8081"))
                .build();
    }
}
