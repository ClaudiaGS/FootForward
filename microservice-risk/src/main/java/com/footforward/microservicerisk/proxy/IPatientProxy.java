package com.footforward.microservicerisk.proxy;

import com.footforward.microservicerisk.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Declare the microservice-patient endpoint
 */
@Validated
@FeignClient(name = "microservice-personaldata", url = "microservice-personaldata:9001")
public interface IPatientProxy {
    
    /**
     * @see com.footforward.microservicepersonaldata.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    PatientBean getPatient(@RequestParam("id") Integer id);
    
    /**
     * @see com.footforward.microservicepersonaldata.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/patient/list")
    List<PatientBean> getPatients() ;
    
    /**
     * @see com.footforward.microservicepersonaldata.controllers
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/patient/update")
    PatientBean updatePatient(@RequestBody @Valid PatientBean patient);
    
    /**
     * @see com.footforward.microservicepersonaldata.controllers
     */
    @RequestMapping(method = RequestMethod.POST, value ="/patient/add")
    PatientBean addPatient(@RequestBody @Valid PatientBean patient);
}
