package com.footforward.microservicemodule.beans;

import java.util.List;

public class RiskBean {
    
    private int patId;
    private String patient;
    private Integer age;
    private String sex;
    private List<String> notes;
    private String assessement;
    private List<String> triggers;
    
    public List<String> getTriggers() {
        return triggers;
    }
    
    public void setTriggers(List<String> triggers) {
        this.triggers = triggers;
    }
    
    public RiskBean() {
    }
    
    public int getPatId() {
        return patId;
    }
    
    public void setPatId(int patId) {
        this.patId = patId;
    }
    
    public String getPatient() {
        return patient;
    }
    
    public void setPatient(String patient) {
        this.patient = patient;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public List<String> getNotes() {
        return notes;
    }
    
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
    
    public String getAssessement() {
        return assessement;
    }
    
    public void setAssessement(String assessement) {
        this.assessement = assessement;
    }
}
