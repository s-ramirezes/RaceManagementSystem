package com.example.demoProjectRMS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherAPI {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
