package com.mycompany.mywebapp.client.gwtservices;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * This is a marker interface, used to indicate that GreetingService
 * is also exposed via GWT RPC
 */
@RemoteServiceRelativePath("gwtrpc/greet")
public interface GreetingGwtService extends RemoteService {

    String greetServer(String name) throws IllegalArgumentException;

}
