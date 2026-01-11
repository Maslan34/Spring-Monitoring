package com.monitoring.basic.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SlackController {


    @GetMapping("/error-test")
    public String errorTest() {
        throw new RuntimeException("A DELIBERATE MISTAKE");
    }
}
