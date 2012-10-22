package com.mycompany.mywebapp.server.rest;

import com.mycompany.services.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Inject
    private GreetingService greetingService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return greetingService.greetServer(name);
    }

}
