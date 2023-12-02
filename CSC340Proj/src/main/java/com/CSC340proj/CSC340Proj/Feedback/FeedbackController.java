package com.CSC340proj.CSC340Proj.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public String getAllFeedback(Model model) {
        model.addAttribute("feedbackList", feedbackService.getAllFeedback());
        return "viewFeedback";
    }

    @GetMapping("/submit")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "submitFeedback";
    }

    @PostMapping
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback";
    }
}