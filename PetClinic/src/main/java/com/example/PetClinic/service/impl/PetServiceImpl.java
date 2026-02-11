package com.example.PetClinic.service.impl;

import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.repository.PetRepository;
import com.example.PetClinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
    
    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);   // ✅ SAFE for managed pets
    }
    
    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }
}
