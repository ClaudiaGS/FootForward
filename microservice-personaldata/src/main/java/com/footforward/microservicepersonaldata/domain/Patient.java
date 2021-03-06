package com.footforward.microservicepersonaldata.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "LastName is mandatory")
    private String lastName;
    @NotBlank(message = "Please insert sex")
    private String sex;
    @NotNull(message = "Date of birth is mandatory")
    private Date dateOfBirth;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
