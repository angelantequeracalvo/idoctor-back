package com.angel.proyectSpring.service;

import com.angel.proyectSpring.controller.dto.AppointmentDTO;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> findAll();

    AppointmentDTO create(AppointmentDTO appointment);

    AppointmentDTO edit(long id, AppointmentDTO appointment);

    void delete (Long appointment);
}
