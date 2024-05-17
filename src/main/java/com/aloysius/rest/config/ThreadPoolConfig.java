package com.aloysius.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean("threadPoolExecutor")
    public ThreadPoolTaskExecutor threadPoolExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(10); // Set the initial number of threads
            executor.setMaxPoolSize(20); // Set the maximum number of threads
            executor.setQueueCapacity(1000); // Set the queue capacity for pending tasks
            executor.initialize(); // Initialize the executor
            return executor;
        }
    }


