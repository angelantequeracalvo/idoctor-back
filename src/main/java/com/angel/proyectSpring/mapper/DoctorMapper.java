package com.angel.proyectSpring.mapper;

import com.angel.proyectSpring.controller.dto.DoctorDTO;
import com.angel.proyectSpring.model.DoctorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DoctorMapper  {


    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
    @Mapping(source = "doctorEntity.apellidos", target = "alias", defaultValue ="alias")
    DoctorDTO entityToDto (DoctorEntity doctorEntity);
    @Mapping(source = "doctorDTO.alias", target ="apellidos", defaultValue ="alias" )
    DoctorEntity dtoToModel (DoctorDTO doctorDTO);
    @Mapping(source = "doctorDTO.alias", target ="apellidos", defaultValue ="alias" )
    List<DoctorEntity> dtoListToEntityList (List<DoctorDTO>doctorDTO);
    @Mapping(source = "doctorEntity.apellidos", target = "alias", defaultValue ="alias")
    List<DoctorDTO> entityToDtoList (List<DoctorEntity>doctorEntity);

}

