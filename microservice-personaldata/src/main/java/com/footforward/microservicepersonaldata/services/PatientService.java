package com.microservicepersonaldata.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicepersonaldata.domain.Patient;
import com.microservicepersonaldata.repositories.IPatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
    
    private static final Logger logger = LogManager.getLogger("PatientService");
    
    @Autowired
    IPatientRepository patientRepository;
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#getPatients()
     */
    @Override
    public List<Patient> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        logger.info("Patient list is " + asJsonString(patients));
        return patients;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#getPatient(Integer)
     */
    @Override
    public Patient getPatient(Integer id) {
        Patient patient = patientRepository.getById(id);
        logger.info("Getting patient info for id=" + id);
        return patient;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#updatePatient(Patient)
     */
    @Override
    public Patient updatePatient(Patient patient) {
        logger.info("Updating patient with id=" + patient.getId());
        return patientRepository.save(patient);
    }
    
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#createPatient(Patient)
     */
    @Override
    @ValidPatient
    public Patient createPatient(Patient patient) {
        logger.info("Creating patient " + asJsonString(patient));
        Patient createdPatient=new Patient();
        List<Patient> patients = getPatients();
        for (Patient p : patients) {
            if (p.getLastName().equals(p.getLastName())&& p.getDateOfBirth().equals(patient.getDateOfBirth()) && p.getAddress().equals(patient.getAddress())) {
                logger.info("Patient already exists");
                createdPatient= null;
                break;
            } else createdPatient=patientRepository.save(patient);
        }
        
      return createdPatient;
//        return alreadyExist(patient);
    }
    
    /**
     * @param obj
     * @return String
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
//    @ValidPatient
//    public Patient alreadyExist(Patient patient) {
//        List<Patient> patients = getPatients();
//        for (Patient p : patients) {
//            if(!(p.getLastName().equals(p.getLastName()))&&!(p.getDateOfBirth().equals(patient.getDateOfBirth()))&&!(p.getAddress().equals(patient.getAddress()))) {
//                return patientRepository.save(patient);
//            }
//        }return null;
//    }
    
    
}
