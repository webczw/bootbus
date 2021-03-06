package com.webczw.bootbus.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class EventBusConfig {

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public AsyncEventBus asyncEventBus() {
        return new AsyncEventBus(Executors.newCachedThreadPool());
    }

}
