package com.angel.proyectSpring.service;

import com.angel.proyectSpring.controller.dto.AppointmentDTO;
import com.angel.proyectSpring.model.AppointmentEntity;
import com.angel.proyectSpring.repository.AppointmentRepository;
import com.angel.proyectSpring.service.impl.AppointmentServiceImpl;
import com.angel.proyectSpring.utils.objectMothers.AppointmentDTOMother;
import com.angel.proyectSpring.utils.objectMothers.AppointmentEntityMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;
    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Test
    public void shouldReturnAllDoctorTest() {
        List<AppointmentEntity> appointmentEntityList = AppointmentEntityMother.returnList();
        List<AppointmentDTO> appointmentDTOList = AppointmentDTOMother.returnList();
        Mockito.when(appointmentRepository.findAll()).thenReturn(appointmentEntityList);
        final List<AppointmentDTO> result=appointmentService.findAll();
        Assertions.assertNotNull(result);
        //Assertions.assertEquals(appointmentDTOList, result);
        Mockito.verify(appointmentRepository).findAll();
    }

    @Test
    public void shouldCreateNewDoctorTest() {

        AppointmentEntity appointmentEntity = AppointmentEntityMother.returnOne();
        AppointmentDTO appointmentDTO = AppointmentDTOMother.returnOne();
        when(appointmentRepository.save(any(AppointmentEntity.class))).thenReturn(new AppointmentEntity());
        appointmentService.create(new AppointmentDTO());
        verify(appointmentRepository,times(1) ).save(any());
    }

    @Test
    public void shouldUpdateDoctorTest(){

        AppointmentEntity appointmentEntity = AppointmentEntityMother.returnOne();
        AppointmentDTO appointmentDTO = AppointmentDTOMother.returnOne();
        Mockito.when(appointmentRepository.save(any(AppointmentEntity.class))).thenReturn(new AppointmentEntity());
        appointmentService.edit(1L, new AppointmentDTO());
        verify(appointmentRepository,times(1) ).save(any());
    }

    @Test
    public void delete(){
        AppointmentEntity appointmentEntity = AppointmentEntityMother.returnOne();
        appointmentService.delete(1L);
        verify(appointmentRepository, times(1)).deleteById(any());
    }
}

