package com.angel.proyectSpring.service;

import com.angel.proyectSpring.controller.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO> findAll();

    void create(DoctorDTO doctor);

    void edit(long id, DoctorDTO doctor);

    void delete (Long doctor);
}
