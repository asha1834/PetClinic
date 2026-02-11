package com.example.PetClinic.controller;

import com.example.PetClinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final OwnerService ownerService;

    public HomeController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String breed,
            Model model) {

        model.addAttribute("owners",
                ownerService.searchOwners(name, city, breed));

        return "home";
    }

}
