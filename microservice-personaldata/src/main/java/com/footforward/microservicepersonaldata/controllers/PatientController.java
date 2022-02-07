package com.footforward.microservicepersonaldata.controllers;

import com.footforward.microservicepersonaldata.domain.Patient;
import com.footforward.microservicepersonaldata.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PatientController {
    
    @Autowired
    IPatientService patientService;
    
    @GetMapping("/patient")
    public Patient getPatient(@RequestParam Integer id){
        return patientService.getPatient(id);
    }
    
    @GetMapping("/patient/list")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }
    
    @PutMapping("/patient/update")
    public Patient updatePatient(@RequestBody @Valid Patient patient) {
       return patientService.updatePatient(patient);
    }
    
    @PostMapping("/patient/add")
    public Patient addPatient(@RequestBody @Valid Patient patient){
        return patientService.createPatient(patient);
    }
}
