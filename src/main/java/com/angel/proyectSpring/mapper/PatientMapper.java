package com.angel.proyectSpring.mapper;

import com.angel.proyectSpring.controller.dto.PatientDTO;
import com.angel.proyectSpring.model.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    @Mapping(source = "patientEntity.apellidos", target = "alias", defaultValue ="alias")
    PatientDTO entityToDto (PatientEntity patientEntity);
    @Mapping(source = "patientDTO.alias", target ="apellidos", defaultValue ="alias" )
    PatientEntity dtoToModel (PatientDTO patientDTO);
    @Mapping(source = "patientDTO.alias", target ="apellidos", defaultValue ="alias" )
    List<PatientEntity> dtoListToEntityList (List<PatientDTO>patientDTO);
    @Mapping(source = "patientEntity.apellidos", target = "alias", defaultValue ="alias")
    List<PatientDTO> entityToDtoList (List<PatientEntity>patientEntity);
}
