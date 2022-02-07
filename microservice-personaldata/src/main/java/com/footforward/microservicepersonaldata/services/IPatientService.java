package com.footforward.microservicepersonaldata.services;

import com.footforward.microservicepersonaldata.domain.Patient;

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
     * @return Patient
     */
    public Patient updatePatient(Patient patient);
    
    /**
     *
     * @param patient
     * @return Patient
     */
    public Patient createPatient(Patient patient);
    
}
