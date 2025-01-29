package org.example.testgrpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class TestGrpcApplication

fun main(args: Array<String>) {
    runApplication<TestGrpcApplication>(*args)
}
