package com.microservicepersonaldata.controllers;

import com.microservicepersonaldata.domain.Patient;
import com.microservicepersonaldata.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PatientController {
    
    @Autowired
    IPatientService patientService;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("patients", patientService.getPatients());
        return "home";
    }
    
    @GetMapping("/patient/add")
    public String addPatient(Patient patient, Model model) {
        model.addAttribute("patient", patient);
        return "add";
    }
    
    @PostMapping("/patient/validate")
    public String validate(@Valid Patient patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            Patient patientCreated=patientService.createPatient(patient);
            if(patientCreated!=null) {
                model.addAttribute("patients", patientService.getPatients());
                return "redirect:/";
            } else return "add"
        }
        return "add";
    }
    
    @GetMapping("/patient/{id}")
    public String patientInfo(@PathVariable Integer id, Model model){
        model.addAttribute("patient",patientService.getPatient(id));
        return "info";
    }
    
    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model){
        model.addAttribute("patient",patientService.getPatient(id));
        return "update";
    }
    @PostMapping("/patient/update/{id}")
    public String updatePatientInfo(@PathVariable Integer id,@Valid Patient patient,BindingResult result, Model model){
        if (!result.hasErrors()) {
            patientService.updatePatient(patient);
            model.addAttribute("patient",patient);
            return "info";
        }
        return "update";
   
    }

}
