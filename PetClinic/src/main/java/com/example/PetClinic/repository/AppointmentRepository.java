package com.example.PetClinic.repository;

import com.example.PetClinic.entity.Appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByPetId(Long petId);
	
}
