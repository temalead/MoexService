package com.example.moexbondservice.client

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FeignConfig {
    @Bean
    open fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.BASIC
    }
}
