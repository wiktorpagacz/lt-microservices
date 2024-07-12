package com.pagacz.progtrack.controller;

import com.pagacz.progtrack.model.ProgressRequest;
import com.pagacz.progtrack.model.ProgressResponse;
import com.pagacz.progtrack.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping
    public ResponseEntity<Long> addProgress(@RequestBody ProgressRequest progressRequest) {
        Long progressId = progressService.saveProgress(progressRequest);
        return new ResponseEntity<>(progressId, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProgressResponse> getProgressById(@PathVariable("id") long progressId) {
        ProgressResponse progressResponse = progressService.getProgressById(progressId);
        return new ResponseEntity<>(progressResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProgressResponse> updateProgress(@PathVariable("id") long progressId, @RequestBody ProgressRequest progressRequest) {
        ProgressResponse progressResponse = progressService.updateProgress(progressId, progressRequest);
        return new ResponseEntity<>(progressResponse, HttpStatus.OK);
    }
}
