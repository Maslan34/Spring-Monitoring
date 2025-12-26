package com.monitoring.basic.Components;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HiScheduler {

    //You can observe this function with /actuator/scheduledtasks endpoint
    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        System.out.println("Scheduled Event Worked: " + System.currentTimeMillis());
    }
}
