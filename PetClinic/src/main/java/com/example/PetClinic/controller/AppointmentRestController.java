package com.example.PetClinic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetClinic.entity.Appointment;
import com.example.PetClinic.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/pet/{petId}")
    public List<Appointment> getAppointmentsByPet(@PathVariable Long petId) {
        return appointmentService.getAppointmentsByPetId(petId);
    }
}

