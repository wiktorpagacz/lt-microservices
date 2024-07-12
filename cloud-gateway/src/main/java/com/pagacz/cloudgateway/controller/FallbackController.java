package com.pagacz.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/activityManagerFallBack")
    public String activityManagerFallBack() {
        return "Activity Manager is down!";
    }
}
