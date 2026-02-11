package com.example.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.service.OwnerService;
import com.example.PetClinic.service.PetService;

@Controller
@RequestMapping("/pets")
public class PetFormController {

    private final OwnerService ownerService;
	private final PetService petService;

    public PetFormController(OwnerService ownerService,PetService petService) {
        this.ownerService = ownerService;
        this.petService =petService;
    }

    @GetMapping("/new/{ownerId}")
    public String showPetForm(@PathVariable Long ownerId, Model model) {

        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("ownerId", ownerId);

        return "pet-form";
    }


    @PostMapping("/save")
    public String savePet(@ModelAttribute Pet pet,
                          @RequestParam Long ownerId) {
        Owner owner = ownerService.findById(ownerId);
        pet.setOwner(owner);
        petService.save(pet);
        return "redirect:/";
    }





    
    @GetMapping("/edit/{petId}")
    public String editPet(@PathVariable Long petId, Model model) {

        Pet pet = petService.getPetById(petId);

        model.addAttribute("pet", pet);
        model.addAttribute("ownerId", pet.getOwner().getId());

        return "pet-form";
    }


}

