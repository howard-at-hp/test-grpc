package org.example.testgrpc.api.grpc

import io.grpc.stub.StreamObserver
import org.example.testgrpc.contracts.proto.GreetingProto
import org.example.testgrpc.contracts.proto.GreetingServiceGrpc
import org.example.testgrpc.contracts.response.Greeting
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class GrpcGreeting : GreetingServiceGrpc.GreetingServiceImplBase() {

    override fun greeting(
        query: GreetingProto.GreetingApiQuery,
        responseObserver: StreamObserver<GreetingProto.GreetingResponse>,
    )  {
        val builder = GreetingProto.GreetingResponse.newBuilder()
        builder.setMessage("Welcome, ${query.name}")
        val response = builder.build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
