package com.mycompany.cli;

import com.mycompany.services.GreetingService;
import org.apache.commons.cli.*;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * "greeter" is the name of the Spring bean
 *
 * In order to execute this app, the user must run ./cli greeter [params]
 */
@Component("greeter")
public class Greeter implements CmdLineApp  {

    @Inject
    private GreetingService greetingService;

    @Override
    public void execute(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("n", "name", true, "Name of person to greet");

        CommandLineParser parser = new PosixParser();
        CommandLine cmdLine = parser.parse(options, args);

        String name = cmdLine.hasOption("n") ? cmdLine.getOptionValue("n") : "Anonymous";

        System.out.println(greetingService.greetServer(name));
    }
}
