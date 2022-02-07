package com.microservicepersonaldata.repositories;

import com.microservicepersonaldata.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * CRUD implementation for Patient object
 *
 */
@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    
//    @Query("select p from patient where p.first_name=:firstName, p.last_name=:lastName,p.sex=:sex,p.date_of_birth=:dateOfBirth, p.address=:address, p.phone=:phone")
//    public Patient alreadyExist(final String firstName, final String lastName, final String sex, final Date dateOfBirth,
//                                final String address, final String phone);
}
