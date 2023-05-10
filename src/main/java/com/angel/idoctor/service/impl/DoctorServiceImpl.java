package com.angel.idoctor.service.impl;

import com.angel.idoctor.controller.dto.DoctorDTO;
import com.angel.idoctor.mapper.DoctorMapper;
import com.angel.idoctor.model.DoctorEntity;
import com.angel.idoctor.repository.DoctorRepository;
import com.angel.idoctor.service.DoctorService;
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

    public DoctorDTO create(DoctorDTO doctor) {
        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.dtoToModel(doctor);
        DoctorEntity doctorCreate = this.doctorRepository.save(doctorEntity);
        return DoctorMapper.INSTANCE.entityToDto(doctorCreate);
    }

    public DoctorDTO edit(long id, DoctorDTO doctor) {
        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.dtoToModel(doctor);
        doctorEntity.setId(id);
        DoctorEntity doctorCreate = this.doctorRepository.save(doctorEntity);
        return DoctorMapper.INSTANCE.entityToDto(doctorCreate);
    }

    public void delete (Long doctor){
        this.doctorRepository.deleteById(doctor);
    }
}
