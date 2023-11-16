package com.example.demoProjectRMS;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = {"",  "/home"})
    public String dashboard(Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("currentUser", name);
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
