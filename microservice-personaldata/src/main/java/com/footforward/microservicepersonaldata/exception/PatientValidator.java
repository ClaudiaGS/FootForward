package com.microservicepersonaldata.exception;

import com.microservicepersonaldata.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class PatientValidator implements ConstraintValidator<ValidPatient, Object[]> {
    @Autowired
    IPatientService patientService;
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        return true;
    }
}
