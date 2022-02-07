package com.microservicepersonaldata.services;

import com.microservicepersonaldata.domain.Patient;

import java.util.List;

public interface IPatientService {
    /**
     *
     * @return List<Patient>
     */
    public List<Patient> getPatients();
    
    /**
     *
     * @param id
     * @return Patient
     */
    public Patient getPatient(Integer id);
    
    /**
     *
     * @param patient
     * @return void
     */
    public Patient updatePatient(Patient patient);
    
    /**
     *
     * @param patient
     * @return void
     */
    public Patient createPatient(Patient patient);
    
}
