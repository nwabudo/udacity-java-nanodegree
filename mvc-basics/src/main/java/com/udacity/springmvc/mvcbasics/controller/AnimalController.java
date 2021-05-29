package com.udacity.springmvc.mvcbasics.controller;

import com.udacity.springmvc.mvcbasics.dtos.MessageForm;
import com.udacity.springmvc.mvcbasics.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    private MessageListService messageListService;

    public AnimalController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(MessageForm messageForm, Model model) {
        messageListService.addMessage("Welcome, Grasshopper.");
        model.addAttribute("greetings", messageListService.getMessages());
        return "harder-home";
    }

    @PostMapping()
    public String highFive(MessageForm messageForm, Model model) {
        messageListService.addMessage("We shall now study the " + messageForm.getAdjective() + " " + messageForm.getAnimalName() + " style.");
        model.addAttribute("greetings", messageListService.getMessages());
        return "harder-home";
    }
}
