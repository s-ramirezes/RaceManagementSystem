package com.CSC340.RMSproj.Engineer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/engineer")
public class RaceEngineerController {
    @Autowired
    private RaceEngineerService raceEngineerService;

    @GetMapping("/strategy")
    public String getAllTracks(Model model,
                              @RequestParam(name = "continue",required = false) String cont) {
        model.addAttribute("tracksList", raceEngineerService.getAllTracks());
        return "engineer/Race_Strategy";
    }
    @PostMapping("/calculate")
    public String calculateStrategy(@RequestParam(value = "track") RaceEngineer track, @RequestParam(value = "laps") int laps, @RequestParam(value = "compounds") int compounds, Model model)
    {
        String[] strategy = raceEngineerService.calculateStrategy(track, laps, compounds);
        model.addAttribute("strategy", strategy);
        return "engineer/Race_Strategy_Calculate";
    }
}
