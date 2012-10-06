package com.mycompany.mywebapp.server.gwtservices;

import com.mycompany.mywebapp.client.gwtservices.GreetingGwtService;
import com.mycompany.mywebapp.server.AutoinjectingRemoteServiceServlet;
import com.mycompany.services.GreetingService;

import javax.inject.Inject;

/**
 * GWT RPC implementation, delegates to the Spring-managed service
 */
public class GreetingGwtServiceImpl extends AutoinjectingRemoteServiceServlet implements GreetingGwtService {

    @Inject
    private GreetingService greetingService;

    @Override
    public String greetServer(String name) throws IllegalArgumentException {
        return greetingService.greetServer(name);
    }
}
