package com.CSC340.RMSproj.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public String getAllFeedback(Model model) {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("username", currentUsername);
        return "Feedback/viewFeedback";
    }

    @GetMapping("/submit")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "Feedback/submitFeedback";
    }

    @PostMapping("/add")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback/all";
    }
}
