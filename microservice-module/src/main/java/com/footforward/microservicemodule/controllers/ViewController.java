package com.footforward.microservicemodule.controllers;

import com.footforward.microservicemodule.beans.NoteBean;
import com.footforward.microservicemodule.beans.PatientBean;
import com.footforward.microservicemodule.beans.RiskBean;
import com.footforward.microservicemodule.proxy.INoteProxy;
import com.footforward.microservicemodule.proxy.IPatientProxy;
import com.footforward.microservicemodule.proxy.IRiskProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ViewController {
    private static final Logger logger = LogManager.getLogger("View");
    @Autowired
    IPatientProxy patientProxy;
    @Autowired
    INoteProxy noteProxy;
    @Autowired
    IRiskProxy riskProxy;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patients", patientProxy.getPatients());
        return "home";
    }
    
    @GetMapping("/patient/add")
    public String addPatient(PatientBean patient, Model model) {
        model.addAttribute("patient", patient);
        return "add";
    }
    
    @PostMapping("/patient/validate")
    public String validate(@Valid PatientBean patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if (patientProxy.addPatient(patient) != null) {
                model.addAttribute("patients", patientProxy.getPatients());
                return "home";
            } else return "redirect:/patient/add";
        }
        return "redirect:/patient/add";
    }
    
    @GetMapping("/patient/{id}")
    public String patientInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientProxy.getPatient(id));
        Integer patId = id;
        model.addAttribute("notes", noteProxy.getNotes(patId));
        return "info";
    }
    
    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientProxy.getPatient(id));
        return "update";
    }
    
    @PostMapping("/patient/update/{id}")
    public String updatePatientInfo(@PathVariable Integer id, @Valid PatientBean patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if (patientProxy.updatePatient(patient) != null) {
                model.addAttribute("patient", patient);
                return "info";
            }
            return "redirect:/patient/{id}";
        }
        return "redirect:/patient/update/{id}";
    }
    
    
    @GetMapping("/note/update/{id}")
    public String showUpdateNoteForm(@PathVariable Integer id, Model model) {
        NoteBean note = noteProxy.getNote(id);
        logger.info("note" ,note);
        model.addAttribute("patient", patientProxy.getPatient(note.getPatId()));
        model.addAttribute("note", note);
        return "updateNote";
    }
    
    @PostMapping("/note/update/{id}")
    public String updateNoteText(@PathVariable Integer id, @Valid NoteBean note, Model model) {
        note.setId(id);
        note.setPatId(noteProxy.getNote(id).getPatId());
  logger.info("here note pat id"+note.getPatId());
        PatientBean patient=patientProxy.getPatient(note.getPatId());
        note.setPatient(patient.getFirstName()+" "+patient.getLastName());
        noteProxy.updateNote(note);
        logger.info("here patient id"+note.getPatId());
        model.addAttribute("patient",patient);
        return "redirect:/patient/"+note.getPatId();
        
    }
    
    @GetMapping("note/add/{id}")
    public String addNote(NoteBean note, @PathVariable Integer id, Model model) {
        model.addAttribute("note", note);
        model.addAttribute("patient", patientProxy.getPatient(id));
        logger.info("here " + patientProxy.getPatient(id).getId());
        return "addNote";
    }
    
    @PostMapping("/note/validate/{id}")
    public String validateNote(NoteBean note, @PathVariable Integer id, Model model) {
        note.setPatId(id);
        PatientBean patient = patientProxy.getPatient(id);
        note.setPatient(patient.getFirstName() + " " + patient.getLastName());
        noteProxy.addNote(note);
        model.addAttribute("notes", noteProxy.getNotes(patient.getId()));
        model.addAttribute("patient", patient);
        return "redirect:/patient/{id}";
        
    }
    
    @GetMapping("/assess/{id}")
    public String getDiabetesAssessement(@PathVariable Integer id, Model model){
        model.addAttribute("patient", patientProxy.getPatient(id));
        model.addAttribute("notes", noteProxy.getNotes(id));
        RiskBean risk=riskProxy.getDiabetesAssessement(id);
        model.addAttribute("risk",risk);
        model.addAttribute("triggers",(risk.getTriggers().toString()));
        return "risk";
    }
}
