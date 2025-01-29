package org.example.testgrpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["org.example"])
class TestGrpcApplication

fun main(args: Array<String>) {
    runApplication<TestGrpcApplication>(*args)
}
