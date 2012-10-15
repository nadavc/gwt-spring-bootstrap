package com.mycompany.cli;

import org.apache.commons.cli.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    private static ApplicationContext createCtx() {
        final String CONTEXT_PATH = "classpath*:/META-INF/spring/*-context.xml";
        return new ClassPathXmlApplicationContext(new String[] {CONTEXT_PATH});
    }

    public static void main(String[] args) throws ParseException {

        // Make sure the user has requested a specific app
        if (args.length == 0) {
            System.out.println("You must input the tool name as a parameter.");
            return;
        }

        String appName = args[0];

        // Load the Spring context from *-context files
        final ApplicationContext ctx = createCtx();

        // Verify that the requested app exists
        if (!ctx.containsBean(appName)) {
            System.out.println("Unable to find " + appName);
            return;
        }

        // And launch it
        CmdLineApp app = (CmdLineApp)ctx.getBean(appName);
        app.execute(args);
    }

}
