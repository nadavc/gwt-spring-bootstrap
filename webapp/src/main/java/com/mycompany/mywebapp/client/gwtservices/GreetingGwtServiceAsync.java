package com.mycompany.mywebapp.client.gwtservices;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The GreetingGwtService that is used by the client
 */
public interface GreetingGwtServiceAsync {

    void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

}
