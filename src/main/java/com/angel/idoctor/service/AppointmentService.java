package com.angel.idoctor.service;

import com.angel.idoctor.controller.dto.AppointmentDTO;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> findAll();

    AppointmentDTO create(AppointmentDTO appointment);

    AppointmentDTO edit(long id, AppointmentDTO appointment);

    void delete (Long appointment);
}
