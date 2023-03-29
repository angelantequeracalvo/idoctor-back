package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.model.DoctorEntity;

import java.util.Collections;
import java.util.List;

public class DoctorEntityMother {

    public static DoctorEntity returnOne(){
        DoctorEntity doctorEntity= new DoctorEntity();
        doctorEntity.setId(1L);
        doctorEntity.setNombre("Angel");
        doctorEntity.setApellidos("Antequera");
        doctorEntity.setEdad(25);
        return doctorEntity;

    }
     public static List<DoctorEntity> returnList(){
        return Collections.singletonList(returnOne());
     }
}
