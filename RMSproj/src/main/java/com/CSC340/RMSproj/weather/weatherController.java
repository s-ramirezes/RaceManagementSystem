package com.CSC340.RMSproj.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class weatherController {
    @Autowired
    private weatherService weatherService;
    @GetMapping("/getWeather")
    public String getWeather(@RequestParam(value = "city", required = false) String city, Model model){
        if (city != null) {
            weather weatherData = weatherService.accessWeather(city);
            model.addAttribute("weather", weatherData);
        }
        return "index";
    }
}
