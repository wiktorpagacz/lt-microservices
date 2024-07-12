package com.pagacz.resvault.controller;

import com.pagacz.resvault.model.CourseRequest;
import com.pagacz.resvault.model.CourseResponse;
import com.pagacz.resvault.service.CourseServ;
import com.pagacz.resvault.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServ courseService;
//    @PostMapping
//    public ResponseEntity<Long> addCourse(@RequestBody CourseRequest courseRequest) {
//        Long courseId = courseService.saveCourse(courseRequest);
//        return new ResponseEntity<>(courseId, HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable("id") long id) {
        CourseResponse courseResponse = courseService.getCourseById(id);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }
}
