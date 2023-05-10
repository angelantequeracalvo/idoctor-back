package com.angel.proyectSpring.mapper;

import com.angel.proyectSpring.controller.dto.AppointmentDTO;
import com.angel.proyectSpring.model.AppointmentEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(target= "idDoctor", source = "doctor.id")
    @Mapping(target= "idPatient", source = "patient.id")
    AppointmentDTO entityToDto (AppointmentEntity appointmentEntity);

    @Mapping(target= "doctor.id", source = "idDoctor")
    @Mapping(target= "patient.id", source = "idPatient")
    AppointmentEntity dtoToModel (AppointmentDTO appointmentDTO);

    List<AppointmentEntity> dtoListToEntityList (List<AppointmentDTO>appointmentDTO);

    List<AppointmentDTO> entityToDtoList (List<AppointmentEntity>doctorEntity);
}
