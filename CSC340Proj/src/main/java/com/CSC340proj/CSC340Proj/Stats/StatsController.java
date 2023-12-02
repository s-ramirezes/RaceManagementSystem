package com.CSC340proj.CSC340Proj.Stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public String viewAllStats(Model model) {
        List<Stats> stats = statsService.getAllStats();
        model.addAttribute("statsList", stats);
        return "/viewStats";
    }

    @GetMapping("/editStats/{id}")
    public String editStats(@PathVariable Long id, Model model) {
        Stats stat = statsService.getStatsById(id);
        model.addAttribute("stat", stat);
        return "editStats";
    }

   @PostMapping("/updateStats")
    public String updateStats(@ModelAttribute Stats updatedStats) {
        statsService.updateStats(updatedStats);
        return "redirect:/driver/stats";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStats(@PathVariable Long id) {
        statsService.deleteStats(id);
        return "redirect:/driver/stats";
    }

    @PostMapping("/createStats")
    public String createStats(@ModelAttribute Stats newStats) {
        statsService.createStats(newStats);
        return "redirect:/driver/stats";


    }
    @GetMapping("/createStats")
    public String createStatsForm(Model model) {
        model.addAttribute("newStats", new Stats());
        return "createStats";
    }

}
