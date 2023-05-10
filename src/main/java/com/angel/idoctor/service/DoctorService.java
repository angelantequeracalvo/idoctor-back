package com.angel.idoctor.service;

import com.angel.idoctor.controller.dto.DoctorDTO;
import java.util.List;

public interface DoctorService {
    List<DoctorDTO> findAll();

    DoctorDTO create(DoctorDTO doctor);

    DoctorDTO edit(long id, DoctorDTO doctor);

    void delete (Long doctor);
}
