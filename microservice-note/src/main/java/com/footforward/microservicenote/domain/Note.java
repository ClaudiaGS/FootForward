package com.footforward.microservicenote.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Document
public class Note {
    @Field("_id")
    @Id
    private Integer id;
    
    @NotNull(message = "patId cannot be null")
    private Integer patId;
    
    @Field("Patient")
    @NotBlank(message = "Patient is mandatory")
    private String patient;
    
    @Field("Practitioner's notes/recommendations")
    @NotBlank(message = "Note cannot be empty")
    private String note;
    
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
    
    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", patId=" + patId +
                ", patient='" + patient + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
