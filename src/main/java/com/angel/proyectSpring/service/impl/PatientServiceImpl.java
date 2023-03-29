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
   // private  final PatientMapper patientMapper;

    public List<PatientDTO> findAll() {
        return PatientMapper.INSTANCE.entityToDtoList(patientRepository.findAll());
       // List<PatientDTO> patientDTOList = new ArrayList<>();
        //List<PatientEntity> patientEntityList = patientRepository.findAll();
        //patientEntityList .forEach( patient -> patientDTOList.add(PatientMapper.INSTANCE.modelToDto(patient)));
       // return patientDTOList;
    }
    public void create(PatientDTO patient) {
        PatientEntity patientEntity = PatientMapper.INSTANCE.dtoToModel(patient);
        this.patientRepository.save(patientEntity);
    }

    public void edit(long id, PatientDTO patient) {

        PatientEntity patientEntity = PatientMapper.INSTANCE.dtoToModel(patient);
        patientEntity.setId(id);
        this.patientRepository.save(patientEntity);
    }

    public void delete (Long patient){

        this.patientRepository.deleteById(patient);
    }



}
