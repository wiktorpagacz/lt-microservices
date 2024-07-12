package com.pagacz.activitymanager.controller;


 import com.pagacz.activitymanager.exception.CustomException;
import com.pagacz.activitymanager.external.client.ResVaultService;
import com.pagacz.resvault.model.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Log4j2
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ResVaultService resVaultService;

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @PostMapping("/course")
    public ResponseEntity<Long> addCourse(@RequestBody CourseRequest courseRequest){
        return resVaultService.addCourse(courseRequest);
    }

//    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/course/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable("id") long id) {
        return resVaultService.getCourseById(id);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") long id) {
        return resVaultService.getBookById(id);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @PostMapping("/book")
    public ResponseEntity<Long> addBook(@RequestBody BookRequest bookRequest) {
        return resVaultService.addBook(bookRequest);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @PutMapping("/book/{id}")
    public ResponseEntity<Long> addBook(@PathVariable("id") long id, @RequestBody BookRequest bookRequest) {
        return resVaultService.updateBook(id, bookRequest);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable("id") long id) {
        return resVaultService.getMovieById(id);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @PostMapping("/movie")
    public ResponseEntity<Long> addMovie(@RequestBody MovieRequest movieRequest) {
        return resVaultService.addMovie(movieRequest);
    }

 }
