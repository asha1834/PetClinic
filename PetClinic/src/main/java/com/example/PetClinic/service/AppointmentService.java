package com.example.PetClinic.service;

import com.example.PetClinic.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    void deleteAppointment(Long id);
    
    List<Appointment> getAppointmentsByPetId(Long petId);
}
