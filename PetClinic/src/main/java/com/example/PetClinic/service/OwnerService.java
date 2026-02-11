package com.example.PetClinic.service;

import com.example.PetClinic.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner saveOwner(Owner owner);

    List<Owner> getAllOwners();

    Owner getOwnerById(Long id);

    void deleteOwner(Long id);
    
    List<Owner> searchOwners(String name, String city, String breed);
    
    Owner findById(Long id);
}
