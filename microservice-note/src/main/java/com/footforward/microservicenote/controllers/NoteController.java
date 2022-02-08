package com.footforward.microservicenote.controllers;

import com.footforward.microservicenote.domain.Note;
import com.footforward.microservicenote.proxy.IPatientProxy;
import com.footforward.microservicenote.services.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteController {
    
    @Autowired
    INoteService noteService;
    @Autowired
    IPatientProxy patientProxy;
    
    
    @GetMapping("/patHistory/list")
    public List<Note> getNotes(@RequestParam Integer patId){
        return noteService.getNotes(patId);
    }
    
    @GetMapping("/patHistory")
    public Note getNote(@RequestParam Integer id) {
        return noteService.getNote(id);
    }
    
    @PutMapping("/patHistory/update")
    public Note updateNote(@RequestBody @Valid Note note) {
        return noteService.updateNote(note);
    }
    
    
    @PostMapping("/patHistory/add")
    public Note addNote(@RequestBody @Valid Note note){
        return noteService.createNote(note);
    }
}