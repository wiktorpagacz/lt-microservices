package com.pagacz.activitymanager.external.client;

import com.pagacz.activitymanager.exception.CustomException;
import feign.FeignException;
import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
@Configuration
public class MyCircuitBreakerAspect {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Around("execution(* com.pagacz.activitymanager.external.client.ResVaultService.*(..))")
    public Object addCircuitBreaker(ProceedingJoinPoint proceedingJoinPoint) {
        io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("testowy");

        return circuitBreaker.executeSupplier(() -> {
            try {
                ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) proceedingJoinPoint.proceed();

                return responseEntity;
            } catch (Throwable throwable) {
                if (throwable.getCause() instanceof FeignException.ServiceUnavailable) {
                    throw new CustomException("ResVault Service not available",
                            "UNAVAILABLE",
                            500);
                }
                if (throwable.getCause() instanceof FeignException.NotFound) {
                    throw new CustomException("Resource not found",
                            "NOT_FOUND",
                            404);
                }
                return throwable.getCause();
            }
        });
    }


}