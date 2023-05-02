package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterConfig.java
 * Class 설명을 작성하세요.
 *
 * @author kjm
 * @since 2023.04.28
 */
//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        p -> p.path("/first-service/**")
                                .filters(f ->
                                        f.addRequestHeader("first-request","first-request-header")
                                        .addResponseHeader("first-response","first-response-header"))
                                .uri("http://localhost:8081"))
                .route(
                        p -> p.path("/second-service/**")
                                .filters(f ->
                                        f.addRequestHeader("second-request","second-request-header")
                                        .addResponseHeader("second-response","second-response-header"))
                                .uri("http://localhost:8082"))
                .build();
    }
}
