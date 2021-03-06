package com.footforward.microservicemodule.proxy;

import com.footforward.microservicemodule.beans.RiskBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Declare the microservice-risk endpoint
 */
@FeignClient(name = "microservice-risk", url = "microservice-risk:9003")
public interface IRiskProxy {
    
    /**
     * @see com.footforward.microservicerisk.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/assess")
    RiskBean getDiabetesAssessement(@RequestParam("id") Integer id);
    
}
