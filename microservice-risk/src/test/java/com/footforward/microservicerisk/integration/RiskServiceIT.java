package com.footforward.microservicerisk.integration;

import com.footforward.microservicerisk.domain.Risk;
import com.footforward.microservicerisk.services.RiskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RiskService.class)
public class RiskServiceIT {
    @Autowired
    RiskService riskService;
 
    
    @Test
    public void countTriggersIT() {
        List<String> notes = new ArrayList<>();
        notes.add("Le patient fume");
        notes.add("Le patient a fait une réaction allergique");
        assertThat(riskService.countTriggers(notes).size()).isEqualTo(2);
    }
    
    @Test
    public void diabetesAssessementCase0() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(35);
        risk.setSex("F");
        risk.setNotes(personNotes);
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("None");
    }
    @Test
    public void diabetesAssessementCase1() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(35);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Réaction");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("None");
    }
    
    @Test
    public void diabetesAssessementCase2Greater30() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(35);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("Borderline");
    }
    
    @Test
    public void diabetesAssessementCase2Smaller30() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(25);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("None");
    }
    
    @Test
    public void diabetesAssessementCase3Smaller30M() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(25);
        risk.setSex("M");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("In Danger");
    }
    
    @Test
    public void diabetesAssessementCase3Greater30M() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(45);
        risk.setSex("M");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("Borderline");
    }
    
    @Test
    public void diabetesAssessementCase3Smaller30F() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(25);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("None");
    }
    
    @Test
    public void diabetesAssessementCase4Smaller30F() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(25);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("In Danger");
    }
    
    @Test
    public void diabetesAssessementCase5Smaller30M() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(25);
        risk.setSex("M");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        triggers.add("Rechute");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("Early onset");
    }
    
    @Test
    public void diabetesAssessementCase6Greater30M() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(35);
        risk.setSex("M");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        triggers.add("Rechute");
        triggers.add("Microalbumine");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("In Danger");
    }
    
    @Test
    public void diabetesAssessementCase7Smaller30F() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(15);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        triggers.add("Rechute");
        triggers.add("Microalbumine");
        triggers.add("Anticorps");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("Early onset");
    }
    
    @Test
    public void diabetesAssessementCase7Greater30F() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(55);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        triggers.add("Rechute");
        triggers.add("Microalbumine");
        triggers.add("Anticorps");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("In Danger");
    }
    
    @Test
    public void diabetesAssessementCase8Greater30F() {
        List<String> personNotes = new ArrayList<>();
        List<String> triggers = new ArrayList<>();
        Risk risk = new Risk();
        risk.setAge(55);
        risk.setSex("F");
        risk.setNotes(personNotes);
        triggers.add("Fume");
        triggers.add("Réaction");
        triggers.add("Poids");
        triggers.add("Vertige");
        triggers.add("Rechute");
        triggers.add("Microalbumine");
        triggers.add("Anticorps");
        triggers.add("Taille");
        RiskService riskService1= Mockito.spy(riskService);
        when(riskService1.countTriggers(risk.getNotes())).thenReturn(triggers);
        assertThat(riskService1.diabetesAssessement(risk)).isEqualTo("Early onset");
    }
}
