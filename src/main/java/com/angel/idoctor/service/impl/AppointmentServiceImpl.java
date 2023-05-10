package com.angel.idoctor.service.impl;

import com.angel.idoctor.controller.dto.AppointmentDTO;
import com.angel.idoctor.mapper.AppointmentMapper;
import com.angel.idoctor.model.AppointmentEntity;
import com.angel.idoctor.repository.AppointmentRepository;
import com.angel.idoctor.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository ;

    public List<AppointmentDTO> findAll() {
        return AppointmentMapper.INSTANCE.entityToDtoList(appointmentRepository.findAll());
    }


    public AppointmentDTO create(AppointmentDTO appointment) {
        AppointmentEntity appointmentEntity = AppointmentMapper.INSTANCE.dtoToModel(appointment);
        AppointmentEntity appointmentCreate = this.appointmentRepository.save(appointmentEntity);
        return AppointmentMapper.INSTANCE.entityToDto(appointmentCreate);
    }


    public AppointmentDTO edit(long id, AppointmentDTO appointment) {
        AppointmentEntity appointmentEntity = AppointmentMapper.INSTANCE.dtoToModel(appointment);
        appointmentEntity.setId(id);
        AppointmentEntity appointmentCreate = this.appointmentRepository.save(appointmentEntity);
        return AppointmentMapper.INSTANCE.entityToDto(appointmentCreate);
    }


    public void delete(Long appointment) {
        this.appointmentRepository.deleteById(appointment);

    }
}
