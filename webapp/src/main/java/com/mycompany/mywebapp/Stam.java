package com.mycompany.mywebapp;

import com.google.gwt.core.client.GWT;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Stam {

    @PostConstruct
    public void pc() {
        GWT.log("Hello from Spring");
    }

    public Stam() {
        GWT.log("constructor");
    }

}
