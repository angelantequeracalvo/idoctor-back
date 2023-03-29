package com.angel.proyectSpring.service.impl;


import com.angel.proyectSpring.controller.dto.DoctorDTO;
import com.angel.proyectSpring.mapper.DoctorMapper;
import com.angel.proyectSpring.model.DoctorEntity;
import com.angel.proyectSpring.repository.DoctorRepository;
import com.angel.proyectSpring.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;


    public List<DoctorDTO> findAll() {
      return DoctorMapper.INSTANCE.entityToDtoList(doctorRepository.findAll());

    }


    public void create(DoctorDTO doctor) {
        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.dtoToModel(doctor);
        this.doctorRepository.save(doctorEntity);
    }


    public void edit(long id, DoctorDTO doctor) {
        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.dtoToModel(doctor);
        doctorEntity.setId(id);
        this.doctorRepository.save(doctorEntity);
    }


    public void delete (Long doctor){
        this.doctorRepository.deleteById(doctor);
    }

}
