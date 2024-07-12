package com.pagacz.activitymanager.external.client;

import com.pagacz.activitymanager.exception.CustomException;
import com.pagacz.progtrack.model.ProgressRequest;
import com.pagacz.progtrack.model.ProgressResponse;
import com.pagacz.resvault.model.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "RESVAULT-SERVICE")
public interface ResVaultService {

    @PostMapping("/api/course")
    ResponseEntity<Long> addCourse(@RequestBody CourseRequest courseRequest);

    @CircuitBreaker(name ="external", fallbackMethod = "fallback")
    @GetMapping("/api/course/{id}")
    ResponseEntity<CourseResponse> getCourseById(@PathVariable("id") long id);

    @PostMapping("/api/book")
    ResponseEntity<Long> addBook(@RequestBody BookRequest bookRequest);

    @PutMapping("/api/book/{id}")
    ResponseEntity<Long> updateBook(@PathVariable("id") long id, @RequestBody BookRequest bookRequest);

    @GetMapping("/api/book/{id}")
    ResponseEntity<BookResponse> getBookById(@PathVariable("id") long id);

    @PostMapping("/api/movie")
    ResponseEntity<Long> addMovie(@RequestBody MovieRequest movieRequest);

    @GetMapping("/api/movie/{id}")
    ResponseEntity<MovieResponse> getMovieById(@PathVariable("id") long id);

    @PostMapping("/api/progress")
    ResponseEntity<Long> addProgress(@RequestBody ProgressRequest progressRequest);

    @GetMapping("/api/progress/{id}")
    ResponseEntity<ProgressResponse> getProgressById(@PathVariable("id") long id);

//    @DefaultCircuitBreake(name = "myServiceCircuitBreaker")
//    @Fallback
//    default <T> ResponseEntity<T> getDataWithFallback(Exception e, Class<T> type) {
//        if (type.equals(Long.class)) {
//            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
//        } else if (type.equals(String.class)) {
//            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
//        } else if (type.equals(MyObject.class)) {
//            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
//        } else {
//            throw new IllegalArgumentException("Unknown response type: " + type.getName());
//        }
//    }

}
