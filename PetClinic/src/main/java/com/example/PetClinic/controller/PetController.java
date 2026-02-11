package com.example.PetClinic.controller;

import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

   /* @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }*/

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
