package com.mycompany.cli;

import org.apache.commons.cli.ParseException;

public interface ConsoleApp {

    void executeFromCli(String[] args) throws ParseException;

}
