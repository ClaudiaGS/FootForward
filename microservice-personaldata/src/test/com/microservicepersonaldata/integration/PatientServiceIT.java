package com.microservicepersonaldata.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicepersonaldata.domain.Patient;
import com.microservicepersonaldata.integration.config.TestConfig;
import com.microservicepersonaldata.services.IPatientService;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Import(TestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PatientServiceIT {
    
    @Autowired
    IPatientService patientService;
    @Autowired
    DataSource dataBaseTest;
    
    @BeforeAll
    public void config() {
        Connection con = null;
        ScriptRunner sr = null;
        Reader reader = null;
        try {
            con = dataBaseTest.getConnection();
            sr = new ScriptRunner(con);
            reader = new BufferedReader(new FileReader("F:\\OPENCLASSROOMS\\PROJET 9\\FootForward1\\microservice-personaldata\\src\\test\\com\\microservicepersonaldata\\integration\\config\\resources\\dataTest.sql"));
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sr.runScript(reader);
        
    }
    
    @Test
    @Order(1)
    public void getPatientsIT() {
        Patient patient=new Patient();
        patient.setId(1);
        patient.setFirstName("firstName1");
        patient.setLastName("lastName1");
        patient.setSex("F");
        patient.setDateOfBirth(Date.valueOf("2000-05-04"));
        patient.setAddress("address1");
        patient.setPhone("phone1");
        assertThat(patientService.getPatients().size()).isEqualTo(2);
        assertThat(asJsonString(patientService.getPatients().get(0))).isEqualTo(asJsonString(patient));
    }
    
    @Test
    @Order(2)
    public void getPatientIT() {
        Patient patient=new Patient();
        patient.setFirstName("firstName1");
        patient.setLastName("lastName1");
        patient.setSex("F");
        patient.setDateOfBirth(Date.valueOf("2000-05-04"));
        patient.setAddress("address1");
        patient.setPhone("phone1");
        assertThat(patientService.getPatient(1).getAddress()).isEqualTo("address1");
    }
    
    @Test
    @Order(3)
    public void updatePatientIT() {
        Patient patient=new Patient();
        patient.setId(1);
        patient.setFirstName("firstName1");
        patient.setLastName("lastName1");
        patient.setSex("F");
        patient.setDateOfBirth(Date.valueOf("2000-05-04"));
        patient.setAddress("address11");
        patient.setPhone("phone1");
        assertThat((patientService.updatePatient(patient)).getAddress()).isEqualTo("address11");
    }
    
    @Test
    @Order(4)
    public void createPatientIT() {
        Patient patient=new Patient();
        patient.setFirstName("firstName3");
        patient.setLastName("lastName3");
        patient.setSex("F");
        patient.setDateOfBirth(Date.valueOf("2000-05-04"));
        patient.setAddress("address3");
        patient.setPhone("phone3");
        Patient createdPatient=patientService.createPatient(patient);
        assertThat(createdPatient.getFirstName()).isEqualTo("firstName3");
        assertThat(createdPatient.getId()).isEqualTo(3);
    }
    
//    @Test
//    @Order(3)
//    public void getPatientsIT() {
//        Patient patient=new Patient();
//        patient.setId(1);
//        patient.setFirstName("firstName1");
//        patient.setLastName("lastName1");
//        patient.setSex("F");
//        patient.setDateOfBirth(Date.valueOf("2000-05-04"));
//        patient.setAddress("address1");
//        patient.setPhone("phone1");
//        assertThat(patientService.getPatients().size()).isEqualTo(2);
//        assertThat(asJsonString(patientService.getPatients().get(0))).isEqualTo(asJsonString(patient));
//    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
