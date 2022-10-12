package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam String firstName, @RequestParam String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.getGreetingMessage(user);
    }

    @PostMapping("/greeting")
    public Greeting addGreeting(@RequestParam String firstName, @RequestParam String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreetingMessage(user);
    }
    @GetMapping("/greeting/{id}")
    public Greeting getGreetingMsgById(@PathVariable("id") long id){
        return greetingService.getGreetingMsgById(id);
    }
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetingMsg(){
        return greetingService.getAllGreetingMsg();
    }

}
