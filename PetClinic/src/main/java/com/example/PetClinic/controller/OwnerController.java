package com.example.PetClinic.controller;

import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "*")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }
    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }
}

