package org.example.testgrpc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["org.example"])
class TestGrpcApplication

fun main(args: Array<String>) {
    SpringApplication.run(TestGrpcApplication::class.java, *args)
}
