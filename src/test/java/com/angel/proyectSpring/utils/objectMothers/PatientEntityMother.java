package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.model.DoctorEntity;
import com.angel.proyectSpring.model.PatientEntity;

import java.util.Collections;
import java.util.List;

public class PatientEntityMother {

    public static PatientEntity returnOne(){
        PatientEntity patientEntity= new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setNombre("Angel");
        patientEntity.setApellidos("Antequera");
        patientEntity.setEdad(25);
        return patientEntity;

    }
    public static List<PatientEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}
