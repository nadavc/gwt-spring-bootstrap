package com.mycompany.services;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class GreetingServiceImpl implements GreetingService {

    private Logger logger = Logger.getLogger(getClass());

    @Inject
    private RandomWordService randomWordService;

    // Only nadav (from firstTenant) is able to access this.
    @Secured("ROLE_GREETER")
    public String greetServer(String name) throws IllegalArgumentException {
        String randomHello = randomWordService.readRandomWordFor("hello");
        String result = String.format("%s, %s!", randomHello, name);

        // Example usage of Log4j
        logger.info("Returning from greetServer() with: " + result);

        return result;
    }
}