package com.mycompany.cli;

import org.apache.commons.cli.ParseException;

public interface CmdLineApp {

    void execute(String args[]) throws ParseException;

}
