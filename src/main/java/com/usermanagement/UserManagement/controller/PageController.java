package com.usermanagement.UserManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String indexPage() {
        return "index"; 
    }

    @GetMapping("/form")
    public String form() {
        return "form";  
    }

    @GetMapping("/thankyou")
    public String thankYou() {
        return "redirect:/thankyou.html";     
    }
}

