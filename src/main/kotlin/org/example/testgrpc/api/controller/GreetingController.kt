package org.example.testgrpc.api.controller

import org.example.testgrpc.contracts.request.GreetingApiQuery
import org.example.testgrpc.contracts.response.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @PostMapping(path = ["/greeting"])
    fun greeting(
        @RequestBody query: GreetingApiQuery,
    ): Greeting {
        return Greeting("Welcome, ${query.name}")
    }

    @GetMapping(path = [""])
    fun getGreeting() : String {
        return "Hello World!"
    }
}
