package com.example.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PetClinic.entity.Appointment;
import com.example.PetClinic.entity.Pet;
import com.example.PetClinic.service.AppointmentService;
import com.example.PetClinic.service.PetService;

@Controller
@RequestMapping("/appointments")
public class AppointmentFormController {

    private final PetService petService;
	private final AppointmentService appointmentService;

    public AppointmentFormController(PetService petService,AppointmentService appointmentService) {
        this.petService = petService;
        this.appointmentService=appointmentService;
    }

    @GetMapping("/new/{petId}")
    public String showForm(@PathVariable Long petId, Model model) {

        Appointment appointment = new Appointment();
        appointment.setPet(petService.getPetById(petId));

        model.addAttribute("appointment", appointment);
        return "appointment-form";
    }

    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute Appointment appointment) {

        Pet pet = petService.getPetById(appointment.getPet().getId());

        if (appointment.getId() != null) {
            // UPDATE existing appointment
            pet.getAppointments().forEach(a -> {
                if (a.getId().equals(appointment.getId())) {
                    a.setAppointmentDate(appointment.getAppointmentDate());
                    a.setDescription(appointment.getDescription());
                }
            });
        } else {
            // CREATE new appointment
            appointment.setPet(pet);
            pet.getAppointments().add(appointment);
        }

        petService.savePet(pet);
        return "redirect:/";
    }

    
    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable Long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);

        return "appointment-form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        Pet pet = appointment.getPet();

        pet.getAppointments().removeIf(a -> a.getId().equals(id));
        petService.savePet(pet);

        return "redirect:/";
    }


}


