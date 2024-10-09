package com.nipuna.grpc_demo.service;

import com.google.protobuf.Descriptors;
import com.nipuna.grpc_demo.GreetingRequest;
import com.nipuna.grpc_demo.GreetingResponse;
import com.nipuna.grpc_demo.GreetingServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GreetingClientService {

    @GrpcClient("grpc-demo-server")
    GreetingServiceGrpc.GreetingServiceBlockingStub synchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getGreetingMessage(String message){

//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
//                .usePlaintext()  // Make sure this is set to use plaintext
//                .build();
//
//        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

 // Above commented code show how to create channel without SSL enable

        GreetingRequest request= GreetingRequest.newBuilder().
                setMessage(message)
                .build();
        GreetingResponse response=synchronousClient.greeting(request);
        return response.getAllFields();
    }
}
