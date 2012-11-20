package com.mycompany.cli;

import org.apache.commons.cli.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.inject.Inject;

public abstract class AbstractConsoleApp implements ConsoleApp {

    private Options options = new Options();

    @Inject
    private UserDetailsService userDetailsService;

    public AbstractConsoleApp() {
        options.addOption("u", "username", true, "Username");
        options.addOption("p", "name", true, "Password");
    }

    public void executeFromCli(String[] args) throws ParseException {
        addOptions(options);                        // Adds options from inheriting classes
        CommandLine cmdLine = parseOptions(args);   // Parses command line params
        authenticate(cmdLine);                      // Authenticate with given user/pass
        try {
            execute(cmdLine);                       // Allow inheriting classes to use options and execute
        } catch (AccessDeniedException ade) {
            System.out.println("User not authorized");
        }
    }

    private CommandLine parseOptions(String[] args) throws ParseException {
        CommandLineParser parser = new PosixParser();
        return parser.parse(options, args);
    }

    private void authenticate(CommandLine cmdLine) {
        String userName = cmdLine.getOptionValue("u");
        String password = cmdLine.getOptionValue("p");

        UserDetails user = userDetailsService.loadUserByUsername(userName);
        if (user.getPassword().equals(password)) {
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }

    protected abstract void addOptions(Options options);

    protected abstract void execute(CommandLine cmdLine);

}
