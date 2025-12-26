package com.monitoring.basic.Components;

import org.springframework.context.annotation.Bean;

public class SampleBean {

    // You need to add to exposure endpoints to "beans"
    @Bean
    public void sampleBean() {
        System.out.println("SampleBean");
    }
}
