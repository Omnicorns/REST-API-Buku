package com.aloysius.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


@SpringBootApplication
public class RestApplication {
    private static final String BACKSLASH ="/";

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(RestApplication.class, args);
       printlnProjects(context);
       System.out.println("  __ ___       __ ___    __ _    _  __ __ ___  __ __ \n" +
                " / _|_   _|/\\   |  _ \\_   _|  / _| |  | |/ __/ __|  __|/ __/ ___|\n" +
                "| (_    | |  /  \\  | |_) | | |    | (_ | |  | | |   | |    | |_  | (_| (_  \n" +
                " \\_ \\   | | / /\\ \\ |  _  /  | |     \\_ \\| |  | | |   | |    |  _|  \\_ \\\\__ \\ \n" +
                " _) |  | |/ __ \\| | \\ \\  | |     __) | || | |_| |_| |__ _) |__) |\n" +
                "|__/   |//    \\\\|  \\\\ ||    |_/ \\_/ \\__\\_|__|_/__/ \n");

    }

    private static void printlnProjects (ConfigurableApplicationContext context){
        ConfigurableEnvironment environment = context.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String appName = environment.getProperty("spring.application.name");
        if (!BACKSLASH.equals(contextPath)) {
            contextPath = contextPath + BACKSLASH;
        }
        String localhostDocUrl = "\nhttp://localhost:" + serverPort + contextPath + "doc.html";
        System.out.println(localhostDocUrl);
        String localhostSwaggerUrl = "http://localhost:" + serverPort + contextPath + "swagger-ui/index.html";
        System.out.println(localhostSwaggerUrl);
        System.out.println(appName);

    }


}
