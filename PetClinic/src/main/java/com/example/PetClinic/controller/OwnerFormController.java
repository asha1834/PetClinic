package com.example.PetClinic.controller;

import com.example.PetClinic.dto.OwnerPetDTO;
import com.example.PetClinic.entity.Appointment;
import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.service.OwnerService;
import com.example.PetClinic.service.PetService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerFormController {

    private final OwnerService ownerService;
    private final PetService petService;

    public OwnerFormController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/new")
    public String newOwner(Model model) {
        model.addAttribute("dto", new OwnerPetDTO());
        return "owner-form";
    }


    
    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute OwnerPetDTO dto) {

        Owner owner;
        if (dto.getOwnerId() != null) {
            owner = ownerService.getOwnerById(dto.getOwnerId());
        } else {
            owner = new Owner();
        }

        owner.setName(dto.getOwnerName());
        owner.setMobile(dto.getMobile());
        owner.setCity(dto.getCity());

        // 🔑 IMPORTANT: work with EXISTING collection
        Pet pet;
        if (owner.getPets() != null && !owner.getPets().isEmpty()) {
            pet = owner.getPets().get(0); // single pet case
        } else {
            pet = new Pet();
            pet.setOwner(owner);
            //owner.getPets().add(pet); // ✅ modify, don’t replace
        }

        pet.setName(dto.getPetName());
        pet.setBreed(dto.getBreed());

        // Appointments (same rule)
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setDescription(dto.getDescription());
        appointment.setPet(pet);

        pet.getAppointments().add(appointment); // ✅ modify existing list

        ownerService.saveOwner(owner);
        return "redirect:/";
    }


    
    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "redirect:/";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editOwner(@PathVariable Long id, Model model) {

        Owner owner = ownerService.getOwnerById(id);

        OwnerPetDTO dto = new OwnerPetDTO();
        dto.setOwnerId(owner.getId());
        dto.setOwnerName(owner.getName());
        dto.setMobile(owner.getMobile());
        dto.setCity(owner.getCity());

        model.addAttribute("dto", dto);
        return "owner-form";
    }



    



}
