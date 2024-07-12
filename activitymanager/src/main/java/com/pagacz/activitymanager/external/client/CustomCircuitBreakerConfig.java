//package com.pagacz.activitymanager.external.client;
//
//import io.github.resilience4j.circuitbreaker.CircuitBreaker;
//import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
//import io.github.resilience4j.timelimiter.TimeLimiterConfig;
//import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
//import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Log4j2
//@Configuration
//public class CustomCircuitBreakerConfig {
//
//    @Autowired
//    private CircuitBreakerRegistry circuitBreakerRegistry;
//
//    @Autowired
//    private TimeLimiterRegistry timeLimiterRegistry;
//
//    @Bean
//    public Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory() {
//        Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory =
//                new Resilience4JCircuitBreakerFactory(circuitBreakerRegistry, timeLimiterRegistry, null);
//        resilience4JCircuitBreakerFactory.configureDefault(this::createResilience4JCircuitBreakerConfiguration);
//        return resilience4JCircuitBreakerFactory;
//    }
//
//    private Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration createResilience4JCircuitBreakerConfiguration(String id) {
//        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(id);
//        CircuitBreakerConfig circuitBreakerConfig = circuitBreaker.getCircuitBreakerConfig();
//        TimeLimiterConfig timeLimiterConfig = timeLimiterRegistry.timeLimiter(id)
//                .getTimeLimiterConfig();
//        circuitBreaker.getEventPublisher()
//                .onEvent(event -> log.error("Circuit-breaker Event Publisher : " + event));
//        return new Resilience4JConfigBuilder(id)
//                .circuitBreakerConfig(circuitBreakerConfig)
////                .timeLimiterConfig(timeLimiterConfig)
//                .build();
//    }
//}
