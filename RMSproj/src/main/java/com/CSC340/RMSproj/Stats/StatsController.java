package com.CSC340.RMSproj.Stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/all")
    public String viewAllStats(Model model) {
        List<Stats> stats = statsService.getAllStats();
        model.addAttribute("statsList", stats);
        return "Stats/viewStats";
    }

    @GetMapping("/editStats/{id}")
    public String editStats(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Stats stat = statsService.getStatsById(id);

        if (stat != null && stat.getDriverName().equals(currentUsername)) {
            model.addAttribute("stat", stat);
            return "Stats/editStats";
        } else {
            redirectAttributes.addFlashAttribute("error", "You are not authorized to edit this stat.");
            return "redirect:/stats/all"; // Redirect to the stats list
        }
    }

    @PostMapping("/updateStats")
    public String updateStats(@ModelAttribute Stats updatedStats) {
        statsService.updateStats(updatedStats);
        return "redirect:/stats/all";
    }

    @DeleteMapping("/delete/{id}")

    public String deleteStats(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Stats stat = statsService.getStatsById(id);

        if (stat != null && stat.getDriverName().equals(currentUsername)) {
            statsService.deleteStats(id);
            return "redirect:/stats/all";
        } else {
            redirectAttributes.addFlashAttribute("error", "You are not authorized to delete this stat.");
            return "redirect:/stats/all";
        }

    }
    @DeleteMapping("/deleteManager/{id}")

    public String deleteStatsManager(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Stats stat = statsService.getStatsById(id);
        if (stat != null) {
            statsService.deleteStats(id);
            return "redirect:/stats/all";
        } else {
            redirectAttributes.addFlashAttribute("error", "You are not authorized to delete this stat.");
            return "redirect:/stats/all";
        }

    }

    @PostMapping("/createStats")
    public String createStats(@ModelAttribute Stats stats, Model model, RedirectAttributes redirectAttributes) {
        // Get the currently logged-in user's username
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        // Check if the driverName matches the currentUsername
        if (stats.getDriverName().equals(currentUsername)) {
            statsService.createStats(stats);
            return "redirect:/stats/all";
        } else {
            // Add an error message to the RedirectAttributes
            redirectAttributes.addFlashAttribute("error", "You can only create stats for your own username.");
            // Redirect back to the creation form
            return "redirect:/stats/createStats";
        }
    }
    @GetMapping("/createStats")
    public String createStatsForm(Model model) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("newStats", new Stats());
        model.addAttribute("username", currentUsername);
        return "Stats/createStats";
    }
}
