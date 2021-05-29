package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.dtos.message.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;
    private UserService userService;

    public ChatController(MessageService messageServiceImpl, UserService userService) {
        this.messageService = messageServiceImpl;
        this.userService = userService;
    }

    @GetMapping()
    public String loadChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        String userName = this.userService.getCurrentSignedUserName();
        model.addAttribute("messages", messageService.getAllChatMessages(userName));
        return "chat";
    }

    @PostMapping()
    public String PostNewChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        messageService.addMessage(chatForm);
        String userName = this.userService.getCurrentSignedUserName();
        model.addAttribute("messages", messageService.getAllChatMessages(userName));
        chatForm.nilOffForm();
        return "chat";
    }

}
