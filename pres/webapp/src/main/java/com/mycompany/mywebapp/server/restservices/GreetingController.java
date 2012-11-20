package com.mycompany.mywebapp.server.restservices;

import com.mycompany.services.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Inject
    private GreetingService greetingService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloByGet(@RequestParam String name) {
        return greetingService.greetServer(name);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloByPost(@RequestParam String name) {
        return greetingService.greetServer(name);
    }

}
