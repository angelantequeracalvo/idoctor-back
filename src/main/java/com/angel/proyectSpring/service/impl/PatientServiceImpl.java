package com.angel.proyectSpring.service.impl;

import com.angel.proyectSpring.controller.dto.PatientDTO;
import com.angel.proyectSpring.mapper.PatientMapper;
import com.angel.proyectSpring.model.PatientEntity;
import com.angel.proyectSpring.repository.PatientRepository;
import com.angel.proyectSpring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public List<PatientDTO> findAll() {
        return PatientMapper.INSTANCE.entityToDtoList(patientRepository.findAll());

    }
    public PatientDTO create(PatientDTO patient) {
        PatientEntity patientEntity = PatientMapper.INSTANCE.dtoToModel(patient);
        PatientEntity patientCreate =   this.patientRepository.save(patientEntity);
        return PatientMapper.INSTANCE.entityToDto(patientCreate);
    }

    public PatientDTO edit(long id, PatientDTO patient) {
        PatientEntity patientEntity = PatientMapper.INSTANCE.dtoToModel(patient);
        patientEntity.setId(id);
        PatientEntity patientCreate = this.patientRepository.save(patientEntity);
        return PatientMapper.INSTANCE.entityToDto(patientCreate);
    }

    public void delete (Long patient){

        this.patientRepository.deleteById(patient);
    }

}
