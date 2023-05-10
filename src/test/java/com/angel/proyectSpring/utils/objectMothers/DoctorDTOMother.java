package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.controller.dto.DoctorDTO;

import java.util.Collections;
import java.util.List;

public class DoctorDTOMother {

    public static DoctorDTO returnOne(){
        DoctorDTO doctorDTO= new DoctorDTO();
        doctorDTO.setId(1L);
        doctorDTO.setName("Angel");
        doctorDTO.setSurname("Antequera");
        doctorDTO.setAge(25);
        return doctorDTO;

    }
    public static List<DoctorDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}
