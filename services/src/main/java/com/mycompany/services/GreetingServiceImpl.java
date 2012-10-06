package com.mycompany.services;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Inject
    private RandomWordService randomWordService;

    public String greetServer(String name) throws IllegalArgumentException {
        String randomHello = randomWordService.readRandomWordFor("hello");

        return String.format("%s, %s!", randomHello, name);
    }
}