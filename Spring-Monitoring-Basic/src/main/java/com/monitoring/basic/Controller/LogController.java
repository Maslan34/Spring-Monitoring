package com.monitoring.basic.Controller;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class LogController {




    // Dynamically update logging configuration at runtime via an endpoint

    // We first obtain the current logging context and then apply the new configuration
    // In production environments, this endpoint must be properly secured


    @PostMapping("/{level}")
        public String changeLogLevel(@PathVariable String level) {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            ch.qos.logback.classic.Logger root =context.getLogger(Logger.ROOT_LOGGER_NAME);

            Level newLevel = Level.toLevel(level.toUpperCase(), Level.INFO);
            root.setLevel(newLevel);

            return "Log level changed to " + newLevel;
        }

    @GetMapping("/error")
    public void throwError() {
            throw new RuntimeException("An error occurred");
    }

}
