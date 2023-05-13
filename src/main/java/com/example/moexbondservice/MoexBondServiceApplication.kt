package com.example.moexbondservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableCaching
open class MoexBondServiceApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<MoexBondServiceApplication>(*args)
        }
    }

}
