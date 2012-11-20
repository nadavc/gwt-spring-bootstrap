package com.mycompany.cli;

import com.mycompany.services.GreetingService;
import org.apache.commons.cli.*;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * "greeter" is the name of the Spring bean
 * <p/>
 * In order to execute this app, the user must run ./cli greeter [params]
 */
@Component("greeter")
public class GreeterConsoleApp extends AbstractConsoleApp {

    @Inject
    private GreetingService greetingService;

    @Override
    protected void addOptions(Options options) {
        options.addOption("n", "name", true, "Name of person to greet");
    }

    @Override
    protected void execute(CommandLine cmdLine) {
        String name = cmdLine.hasOption("n") ? cmdLine.getOptionValue("n") : "Anonymous";
        System.out.println(greetingService.greetServer(name));
    }

}
