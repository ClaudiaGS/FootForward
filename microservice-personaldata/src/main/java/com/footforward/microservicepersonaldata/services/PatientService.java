package com.footforward.microservicepersonaldata.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.footforward.microservicepersonaldata.domain.Patient;
import com.footforward.microservicepersonaldata.repositories.IPatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        logger.info("Patient list is: " + patients);
        return patients;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#getPatient(Integer)
     */
    @Override
    public Patient getPatient(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        Patient patientToReturn = patient.get();
        logger.info("Getting patient info for id=" + id);
        return patientToReturn;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#updatePatient(Patient)
     */
    @Override
    public Patient updatePatient(Patient patient) {
        logger.info("Updating patient with id=" + patient.getId());
        if(alreadyExist(patient)){
            logger.info("Person with data you just modified already exists");
            return null;
        }
        return patientRepository.save(patient);
    }
    
    
    /**
     * (non-javadoc)
     *
     * @see IPatientService#createPatient(Patient)
     */
    @Override
    //@ValidPatient
    public Patient createPatient(Patient patient) {
        logger.info("Creating patient {}",patient);
        if (alreadyExist(patient)) {
            logger.info("Patient already exists");
            return null;
        }
      return patientRepository.save(patient);
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
    
    /**
     * check if patient already exists in DB
     * @param patient
     * @return boolean
     */
    public boolean alreadyExist(Patient patient) {
        List<Patient> patients = getPatients();
        for (Patient p : patients) {
            if (p.getFirstName().equals(patient.getFirstName())&&p.getLastName().equals(patient.getLastName()) && p.getDateOfBirth().toString().equals(patient.getDateOfBirth().toString()) && p.getAddress().equals(patient.getAddress())&&p.getPhone().equals(patient.getPhone())&&p.getSex().equals(patient.getSex())) {
                return true;
            }
        }
        return false;
    }
    
    
}
