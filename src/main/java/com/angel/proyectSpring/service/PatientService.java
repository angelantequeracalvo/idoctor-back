package com.angel.proyectSpring.service;

import com.angel.proyectSpring.controller.dto.PatientDTO;
import java.util.List;

public interface PatientService {

    List<PatientDTO> findAll();

    PatientDTO create(PatientDTO patient);

    PatientDTO edit(long id, PatientDTO patient);

    void delete (Long patient);
}
