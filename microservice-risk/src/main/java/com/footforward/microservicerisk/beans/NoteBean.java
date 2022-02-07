package com.footforward.microservicerisk.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NoteBean {
 
    private Integer id;
    
    @NotNull(message = "patId cannot be null")
    private Integer patId;
    
    @NotBlank(message = "Patient is mandatory")
    private String patient;
    
    @NotBlank(message = "Note cannot be empty")
    private String note;
    
    
    public NoteBean() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getPatId() {
        return patId;
    }
    
    public void setPatId(Integer patId) {
        this.patId = patId;
    }
    
    public String getPatient() {
        return patient;
    }
    
    public void setPatient(String patient) {
        this.patient = patient;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
}
