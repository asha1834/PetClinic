package com.example.PetClinic.repository;

import com.example.PetClinic.entity.Owner;
import com.example.PetClinic.entity.Pet;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class OwnerSpecification {

    public static Specification<Owner> hasOwnerName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) return null;
            return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<Owner> hasCity(String city) {
        return (root, query, cb) -> {
            if (city == null || city.isBlank()) return null;
            return cb.like(cb.lower(root.get("city")), "%" + city.toLowerCase() + "%");
        };
    }

    public static Specification<Owner> hasPetBreed(String breed) {
        return (root, query, cb) -> {
            if (breed == null || breed.isBlank()) return null;

            Join<Owner, Pet> petJoin = root.join("pets", JoinType.LEFT);
            return cb.like(cb.lower(petJoin.get("breed")), "%" + breed.toLowerCase() + "%");
        };
    }
}
