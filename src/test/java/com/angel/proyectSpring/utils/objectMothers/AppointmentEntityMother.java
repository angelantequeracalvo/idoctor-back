package com.angel.proyectSpring.utils.objectMothers;

import com.angel.proyectSpring.model.AppointmentEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AppointmentEntityMother {
    public static AppointmentEntity returnOne(){
        AppointmentEntity appointmentEntity= new AppointmentEntity();
        appointmentEntity.setId(1L);
        appointmentEntity.setDoctor(DoctorEntityMother.returnOne());
        appointmentEntity.setPatient(PatientEntityMother.returnOne());
        appointmentEntity.setAppointmentDate(new Date());
        return appointmentEntity;
    }
    public static List<AppointmentEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}
