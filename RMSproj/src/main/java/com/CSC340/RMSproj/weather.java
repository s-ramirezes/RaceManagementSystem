package com.CSC340.RMSproj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weather {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
