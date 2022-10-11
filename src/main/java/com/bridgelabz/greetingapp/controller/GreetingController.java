package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(name = "firstName", defaultValue = "Hello") String firstName,
                             @RequestParam(name = "lastName", defaultValue = "World") String lastName){
        String name = firstName +" "+ lastName;
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @PostMapping("/greeting")
    public Greeting greetingPost(@RequestParam String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

}
