package com.example.PetClinic.service.impl;

import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.repository.OwnerRepository;
import com.example.PetClinic.service.OwnerService;
import org.springframework.stereotype.Service;

import org.springframework.data.jpa.domain.Specification;
import static com.example.PetClinic.repository.OwnerSpecification.*;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
    
    @Override
    public List<Owner> searchOwners(String name, String city, String breed) {

        Specification<Owner> spec = Specification
                .where(hasOwnerName(name))
                .and(hasCity(city))
                .and(hasPetBreed(breed));

        return ownerRepository.findAll(spec);
}
    
    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }
    

}
