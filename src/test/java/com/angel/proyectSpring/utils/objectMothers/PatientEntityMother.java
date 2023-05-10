package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.model.PatientEntity;

import java.util.Collections;
import java.util.List;

public class PatientEntityMother {

    public static PatientEntity returnOne(){
        PatientEntity patientEntity= new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setName("Angel");
        patientEntity.setSurname("Antequera");
        patientEntity.setAge(25);
        return patientEntity;

    }
    public static List<PatientEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}
