package com.angel.idoctor.utils.objectMothers;

import com.angel.idoctor.controller.dto.AppointmentDTO;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AppointmentDTOMother {
    public static AppointmentDTO returnOne(){
        AppointmentDTO AppointmentDTO= new AppointmentDTO();
        AppointmentDTO.setAppointmentDate(new Date());
        AppointmentDTO.setIdDoctor(1L);
        AppointmentDTO.setIdPatient(1L);
        return AppointmentDTO;

    }
    public static List<AppointmentDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}
