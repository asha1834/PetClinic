package com.example.PetClinic.service;

import com.example.PetClinic.entity.Pet;

import java.util.List;

public interface PetService {

   Pet savePet(Pet pet);

    List<Pet> getAllPets();

    Pet getPetById(Long id);

    void deletePet(Long id);
    
    void save(Pet pet);  
}
