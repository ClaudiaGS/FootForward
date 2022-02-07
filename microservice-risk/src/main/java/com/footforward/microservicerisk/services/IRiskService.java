package com.footforward.microservicerisk.services;

import com.footforward.microservicerisk.domain.Risk;

import java.util.List;

public interface IRiskService {
    
    /**
     *
     * @param risk
     * @return String
     */
    public String diabetesAssessement(Risk risk);
    
    /**
     *
     * @param notes
     * @return Integer
     */
    public List<String > countTriggers(List<String> notes);
    
}
