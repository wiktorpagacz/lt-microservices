package com.pagacz.resvault.controller;

import com.pagacz.resvault.model.CourseRequest;
import com.pagacz.resvault.model.CourseResponse;
import com.pagacz.resvault.model.MovieRequest;
import com.pagacz.resvault.model.MovieResponse;
import com.pagacz.resvault.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Long> addMovie(@RequestBody MovieRequest movieRequest) {
        Long movieId = movieService.saveMovie(movieRequest);
        return new ResponseEntity<>(movieId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable("id") long id) {
        MovieResponse movieResponse = movieService.getMovieById(id);
        return new ResponseEntity<>(movieResponse, HttpStatus.OK);
    }
}
