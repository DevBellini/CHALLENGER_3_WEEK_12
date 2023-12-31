package br.guilherme.bellini.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class MsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/employees/**").uri("lb://ms-employees"))
                .route(r -> r.path("/proposal/**").uri("lb://ms-proposal"))
 		.route(r -> r.path("/proposal-info/**").uri("lb://ms-votes"))
                .route(r -> r.path("/vote-validation/**").uri("lb://ms-votes"))
                .build();

    }
}
