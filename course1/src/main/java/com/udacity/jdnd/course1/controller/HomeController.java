package com.udacity.jdnd.course1.controller;

import com.udacity.jdnd.course1.dto.message.ChatForm;
import com.udacity.jdnd.course1.dto.message.ChatMessage;
import com.udacity.jdnd.course1.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {


    private MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String loadChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getAllChatMessages());
        return "home";
    }

    @PostMapping()
    public String PostNewChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        messageService.addMessage(chatForm);
        model.addAttribute("messages", messageService.getAllChatMessages());
        chatForm.nilOffForm();
        return "home";
    }

}
