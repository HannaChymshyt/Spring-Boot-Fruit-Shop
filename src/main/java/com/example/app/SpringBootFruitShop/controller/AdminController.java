package com.example.app.SpringBootFruitShop.controller;

import com.example.app.SpringBootFruitShop.service.Admin.AdminCoconutService;
import com.example.app.SpringBootFruitShop.service.Admin.AdminPearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminPearService userPearService;
    @Autowired
    AdminCoconutService userCoconutService;

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("title", "Fruit Shop");
        model.addAttribute("fragmentName", "home");
        return "Admin/layout";
    }

    @GetMapping("/coconut")
    public String getCoconuts(Model model) {
        model.addAttribute("title", "Coconut");
        model.addAttribute("coconuts", userCoconutService.getAll());
        model.addAttribute("fragmentName", "coconuts");
        return "Admin/layout";
    }

    @GetMapping("/pear")
    public String getPears(Model model) {
        model.addAttribute("title", "Pears");
        model.addAttribute("pears", userPearService.getAll());
        model.addAttribute("fragmentName", "pears");
        return "Admin/layout";
    }
}
