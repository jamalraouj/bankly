package com.gateway.gateway;

import com.gateway.gateway.config.AuthFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

//        return builder.routes()
//                .route(p -> p.path("/bankly/user/**").filters(f -> f.fi)
//
//                        .uri("lb://user"))
//                .route(p -> p.path("/bankly/transaction/**")
//                        .uri("lb://transaction"))
//                .route(p -> p.path("/bankly/wallet/**")
//                        .uri("lb://wallet"))
//                .route(p -> p.path("/jobs/**")
//                        .uri("lb://job-services"))
//                .build();
//
//    }
}
