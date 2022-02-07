package com.footforward.microservicepersonaldata.repositories;

import com.footforward.microservicepersonaldata.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * CRUD implementation for Patient object
 *
 */
@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
