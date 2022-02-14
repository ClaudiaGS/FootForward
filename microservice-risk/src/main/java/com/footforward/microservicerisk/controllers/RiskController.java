package com.footforward.microservicerisk.controllers;

import com.footforward.microservicerisk.beans.NoteBean;
import com.footforward.microservicerisk.beans.PatientBean;
import com.footforward.microservicerisk.domain.Risk;
import com.footforward.microservicerisk.proxy.INoteProxy;
import com.footforward.microservicerisk.proxy.IPatientProxy;
import com.footforward.microservicerisk.services.IRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RiskController {
    
    @Autowired
    IRiskService riskService;
    @Autowired
    INoteProxy noteProxy;
    @Autowired
    IPatientProxy patientProxy;
    
    @GetMapping("/assess")
    public Risk getDiabetesAssessement(@RequestParam Integer id) {
        PatientBean patient = patientProxy.getPatient(id);
        List<NoteBean> notesBean = noteProxy.getNotes(id);
        List<String> notes = new ArrayList<>();
        for (NoteBean n : notesBean) {
            notes.add(n.getNote());
        }
        LocalDate actualDate = LocalDate.now();
        int age=Period.between(patient.getDateOfBirth().toLocalDate(),actualDate).getYears();
        Risk risk = new Risk();
        risk.setPatId(id);
        risk.setPatient(patient.getFirstName() + " " + patient.getLastName());
        risk.setAge(age);
        risk.setSex(patient.getSex());
        risk.setNotes(notes);
        risk.setAssessement(riskService.diabetesAssessement(risk));
        risk.setTriggers(riskService.countTriggers(notes));
        return risk;
    }
    
}
