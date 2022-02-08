package com.footforward.microservicemodule.beans;

public class NoteBean {
    private Integer id;

    private Integer patId;

    private String patient;

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
