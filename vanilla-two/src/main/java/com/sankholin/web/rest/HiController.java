package com.sankholin.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sankholin.core.model.SimpleMessage;

@Controller
public class HiController {

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        return "Hi, world.";
    }

    @RequestMapping("/rest/hi")
    @ResponseBody
    public SimpleMessage restHi(@RequestParam(value = "name", required = false) String name) throws InterruptedException {
        if (name == null || name.isEmpty()) {
            return new SimpleMessage("Hi, world");
        }
        return new SimpleMessage("Hi, " + name);
    }
}