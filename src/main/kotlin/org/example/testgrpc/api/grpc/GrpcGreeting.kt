package org.example.testgrpc.api.grpc

import org.example.testgrpc.contracts.proto.GreetingProto
import org.example.testgrpc.contracts.proto.GreetingServiceGrpc
import org.example.testgrpc.contracts.response.Greeting
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class GrpcGreeting : GreetingServiceGrpc.GreetingServiceImplBase() {

    @Override
    fun greeting(query: GreetingProto.GreetingApiQuery) : GreetingProto.GreetingResponse {
        val builder = GreetingProto.GreetingResponse.newBuilder()
        builder.setMessage("Welcome, ${query.name}")
        return builder.build()
    }
}
