package com.mycompany.mywebapp.server.gwtservices;

import com.mycompany.mywebapp.client.gwtservices.GreetingGwtService;
import com.mycompany.services.GreetingService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * GWT RPC implementation, delegates to the Spring-managed service
 */
@Service("greet")
public class GreetingGwtServiceImpl implements GreetingGwtService {

    @Inject
    private GreetingService greetingService;

    @Override
    public String greetServer(String name) throws IllegalArgumentException {
        return greetingService.greetServer(name);
    }
}
