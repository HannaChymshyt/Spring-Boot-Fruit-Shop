package com.example.app.SpringBootFruitShop.controller;

import com.example.app.SpringBootFruitShop.service.User.UserPearService;
import com.example.app.SpringBootFruitShop.service.User.UserOrderService;
import com.example.app.SpringBootFruitShop.service.User.UserCoconutService;
import com.example.app.SpringBootFruitShop.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserCoconutService userCoconutService;
    @Autowired
    UserPearService userPearService;
    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Fruit Shop");
        model.addAttribute("fragmentName", "home");
        return "User/layout";
    }

    @GetMapping("/coconuts")
    public String getTShirts(Model model) {
        model.addAttribute("title", "Coconuts");
        model.addAttribute("coconuts", userCoconutService.getAll());
        model.addAttribute("fragmentName", "coconuts");
        return "User/layout";
    }

    @GetMapping("/pears")
    public String getCaps(Model model) {
        model.addAttribute("title", "Pears");
        model.addAttribute("pears", userPearService.getAll());
        model.addAttribute("fragmentName", "pears");
        return "User/layout";
    }

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("title", "Contacts");
        model.addAttribute("fragmentName", "contacts");
        return "User/layout";
    }

    @PostMapping("/order")
    public ResponseEntity<?> makeOrder(
            @RequestParam("userName") String userName,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userOrderMsg") String userOrderMsg) {

        String[] data = new String[]{userName, userPhone,
                userEmail, userOrderMsg};

        String orderCode;

        try {
            orderCode = userOrderService.makeOrder(data);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(false,
                    "Error."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ResponseMessage(true,
                "Your order code is " + orderCode + ". Do not lost it, please."),
                HttpStatus.OK);
    }
}
