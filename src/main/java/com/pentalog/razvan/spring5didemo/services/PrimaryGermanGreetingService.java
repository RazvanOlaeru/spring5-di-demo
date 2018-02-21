package com.pentalog.razvan.spring5didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("de")
@Primary
public class PrimaryGermanGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hallo - Ich wurde vom Primary Greeting Service eingespritzt";
    }
}
