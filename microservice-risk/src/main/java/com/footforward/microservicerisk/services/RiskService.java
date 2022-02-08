package com.footforward.microservicerisk.services;

import com.footforward.microservicerisk.domain.Risk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RiskService implements IRiskService {
    private static final Logger logger = LogManager.getLogger("RiskService");
    
    /**
     * (non-javadoc)
     *
     * @see IRiskService#diabetesAssessement(Risk)
     */
    public String diabetesAssessement(Risk risk) {
        logger.info("Generating report");
        int age = risk.getAge();
        logger.info("age is " + age);
        String sex = risk.getSex();
        String assessement = null;
        int triggersCount = countTriggers(risk.getNotes()).size();
        switch (triggersCount) {
            case 0:
                assessement = "None";
                break;
            case 1:
                assessement = "None";
                break;
            case 2:
                if (age >= 30) {
                    assessement = "Borderline";
                } else {
                    assessement = "None";
                }
                break;
            case 3:
                if (age < 30) {
                    if (sex.equals("M")) {
                        assessement = "In Danger";
                    } else {
                        assessement = "None";
                    }
                } else {
                    assessement = "Borderline";
                }
                break;
            case 4:
                if (age < 30) {
                    assessement = "In Danger";
                } else {
                    assessement = "Borderline";
                }
                break;
            case 5:
                if (age < 30) {
                    if (sex.equals("M")) {
                        assessement = "Early onset";
                    } else {
                        assessement = "In Danger";
                    }
                } else {
                    assessement = "Borderline";
                }
                break;
            case 6:
                if (age >= 30) {
                    assessement = "In Danger";
                } else {
                    if (sex.equals("M")) {
                        assessement = "Early onset";
                    } else {
                        assessement = "In Danger";
                    }
                }
                break;
            case 7:
                if (age < 30) {
                    assessement = "Early onset";
                } else {
                    assessement = "In Danger";
                }
                break;
            case 8:
                assessement = "Early onset";
                break;
            default:
                if (triggersCount > 8) {
                    assessement = "Early onset";
                } else {
                    assessement = "None";
                }
        }
        return assessement;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IRiskService#countTriggers(List)
     */
    public List<String> countTriggers(List<String> notes) {
        logger.info("Counting triggers");
        int count = 0;
        List<String> triggers = new ArrayList<>();
        
        //diabetics risk triggers to search for
        Collections.addAll(triggers, "Hémoglobine A1C", "Microalbumine", "Taille", "Poids",
                "Fume", "Anormal", "Cholestérol", "Vertige", "Rechute", "Réaction", "Anticorps");
        
        List<String> triggersFound = new ArrayList<>();
        
        for (String note : notes) {
            for (String trigger : triggers) {
                if ((StringUtils.trimAllWhitespace(note.toLowerCase())).contains(StringUtils.trimAllWhitespace(trigger.toLowerCase())) && !(triggersFound.contains(trigger.toLowerCase()))) {
                    triggersFound.add(trigger);
                    count += 1;
                }
            }
        }
        
        logger.info("Patient history has " + count + " diabetes triggers");
        return triggersFound;
    }
}
