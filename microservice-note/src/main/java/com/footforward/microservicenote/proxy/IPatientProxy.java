package com.footforward.microservicenote.proxy;

import com.footforward.microservicenote.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Declare the microservice-patient endpoint
 */
@FeignClient(name = "microservice-personaldata", url = "localhost:9001")
public interface IPatientProxy {
    
    /**
     * @see com.footforward.microservicepersonaldata.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    PatientBean getPatient(@RequestParam("id") Integer id);
    

    
}
