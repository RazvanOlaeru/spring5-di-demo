package com.pentalog.razvan.spring5didemo.controllers;

import com.pentalog.razvan.spring5didemo.services.GreetingService;
import com.pentalog.razvan.spring5didemo.services.GreetingServiceImpl;

public class PropertyInjectedController {

    public GreetingServiceImpl greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
