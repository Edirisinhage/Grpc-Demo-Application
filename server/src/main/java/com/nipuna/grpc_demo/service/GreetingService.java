package com.nipuna.grpc_demo.service;

import com.nipuna.grpc_demo.GreetingRequest;
import com.nipuna.grpc_demo.GreetingResponse;
import com.nipuna.grpc_demo.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message=request.getMessage();
        System.out.println("Recieved message: "+message);

        GreetingResponse greetingResponse=GreetingResponse.newBuilder()
                .setMessage("Recieved your "+message+" from server")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();


    }
}
