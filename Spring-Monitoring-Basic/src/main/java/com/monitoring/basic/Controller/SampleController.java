package com.monitoring.basic.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/monitoring")
public class SampleController {


    // You can observe this endpoint requesting to /actuator/mappings.
    @GetMapping
    public String hello() {
        return "Hello Spring";
    }
}
