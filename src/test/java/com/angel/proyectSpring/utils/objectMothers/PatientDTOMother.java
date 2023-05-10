package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.controller.dto.PatientDTO;

import java.util.Collections;
import java.util.List;

public class PatientDTOMother {


    public static PatientDTO returnOne(){
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setId(1L);
        patientDTO.setName("Angel");
        patientDTO.setSurname("Antequera");
        patientDTO.setAge(25);
        return patientDTO;

    }
    public static List<PatientDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}
