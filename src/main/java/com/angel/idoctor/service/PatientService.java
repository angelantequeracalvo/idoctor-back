package com.angel.idoctor.service;

import com.angel.idoctor.controller.dto.PatientDTO;
import java.util.List;

public interface PatientService {

    List<PatientDTO> findAll();

    PatientDTO create(PatientDTO patient);

    PatientDTO edit(long id, PatientDTO patient);

    void delete (Long patient);
}
