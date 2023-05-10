package com.angel.proyectSpring.mapper;

import com.angel.proyectSpring.controller.dto.PatientDTO;
import com.angel.proyectSpring.model.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO entityToDto (PatientEntity patientEntity);
    PatientEntity dtoToModel (PatientDTO patientDTO);
    List<PatientEntity> dtoListToEntityList (List<PatientDTO>patientDTO);
    List<PatientDTO> entityToDtoList (List<PatientEntity>patientEntity);
}
