package com.nipuna.grpc_demo.controller;

import com.google.protobuf.Descriptors;
import com.nipuna.grpc_demo.service.GreetingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GreetingController {

    @Autowired
    private GreetingClientService greetingClientService;

    public GreetingController(GreetingClientService greetingClientService) {
        this.greetingClientService = greetingClientService;
    }

    @PostMapping("/greeting")
    public Map<Descriptors.FieldDescriptor, Object> getGreeting(@RequestBody Request greeting){
         return greetingClientService.getGreetingMessage(greeting.getMessage());
    }
}
