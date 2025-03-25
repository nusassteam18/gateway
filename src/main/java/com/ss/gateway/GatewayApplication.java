package com.ss.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
//				.route("user_service", r -> r.path("/users/**")
//						.uri("lb://user-service"))
				.route("user_service", r -> r.path("/users/**")
						.uri("http://127.0.0.1:8081"))
				.route("restaurant_service", r -> r.path("/restaurants/**")
						.uri("http://127.0.0.1:8082"))
				.route("order_service", r -> r.path("/orders/**")
						.uri("http://127.0.0.1:8083"))
				.build();
	}
}
