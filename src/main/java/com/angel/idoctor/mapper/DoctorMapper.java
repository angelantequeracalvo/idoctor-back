package com.angel.idoctor.mapper;

import com.angel.idoctor.controller.dto.DoctorDTO;
import com.angel.idoctor.model.DoctorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DoctorMapper  {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);


    DoctorDTO entityToDto (DoctorEntity doctorEntity);

    DoctorEntity dtoToModel (DoctorDTO doctorDTO);

    List<DoctorEntity> dtoListToEntityList (List<DoctorDTO>doctorDTO);
   // @Mapping(source = "doctorEntity.surname", target = "surname", defaultValue ="surname")
    List<DoctorDTO> entityToDtoList (List<DoctorEntity>doctorEntity);

}

