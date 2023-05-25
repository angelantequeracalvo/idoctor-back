package com.angel.idoctor.utils.objectMothers;

import com.angel.idoctor.controller.dto.AppointmentDTO;
import com.angel.idoctor.controller.dto.DoctorDTO;
import com.angel.idoctor.controller.dto.PatientDTO;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AppointmentDTOMother {
    public static AppointmentDTO returnOne(){
        AppointmentDTO AppointmentDTO= new AppointmentDTO();
        AppointmentDTO.setAppointmentDate(new Date());
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(1L);
        AppointmentDTO.setDoctor(doctorDTO);
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(1L);
        AppointmentDTO.setPatient(patientDTO);
        return AppointmentDTO;

    }
    public static List<AppointmentDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}
