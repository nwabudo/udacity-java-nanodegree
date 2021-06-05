package com.udacity.springmvc.mvcbasics.controller;

import com.udacity.springmvc.mvcbasics.dtos.MessageForm;
import com.udacity.springmvc.mvcbasics.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService){
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(MessageForm messageForm, Model model) {
        messageListService.addMessage("low five.");
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

    @PostMapping()
    public String highFive(MessageForm messageForm, Model model) {
        messageListService.addMessage("high five, " + messageForm.getText() + "!");
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }

}
