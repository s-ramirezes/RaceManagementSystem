package com.CSC340.RMSproj.Engineer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/engineer")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String getMessage(Model model,
                               @RequestParam(name = "continue",required = false) String cont) {
        model.addAttribute("message", messageService.getMessage());
        return "engineer/Live_Communication";
    }
    @PostMapping("/")
    public String sendMessage(@RequestParam(value = "sentMessage") String sentMessage, Model model)
    {
        System.out.println(sentMessage);
        messageService.deleteAll();
        messageService.sendMessage(new Message(sentMessage));
        model.addAttribute("message", messageService.getMessage());
        return "redirect:/live_feedback/";
    }
}
