package com.angel.idoctor.service;

import com.angel.idoctor.controller.dto.DoctorDTO;
import com.angel.idoctor.model.DoctorEntity;
import com.angel.idoctor.repository.DoctorRepository;
import com.angel.idoctor.service.impl.DoctorServiceImpl;
import com.angel.idoctor.utils.objectMothers.DoctorDTOMother;
import com.angel.idoctor.utils.objectMothers.DoctorEntityMother;
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
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;
    @InjectMocks
    private DoctorServiceImpl doctorService;

    @Test
    public void shouldReturnAllDoctorTest() {
        List<DoctorEntity> doctorEntityList = DoctorEntityMother.returnList();
        List<DoctorDTO> doctorDTOList = DoctorDTOMother.returnList();
      Mockito.when(doctorRepository.findAll()).thenReturn(doctorEntityList);
      final List<DoctorDTO> result= doctorService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(doctorDTOList, result);
        Mockito.verify(doctorRepository).findAll();
    }

    @Test
    public void shouldCreateNewDoctorTest() {

       DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
       DoctorDTO doctorDTO = DoctorDTOMother.returnOne();
        when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(new DoctorEntity());
        doctorService.create(new DoctorDTO());
        verify(doctorRepository,times(1) ).save(any());
    }

    @Test
    public void shouldUpdateDoctorTest(){

        DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
        doctorEntity.setName("pepito");
        DoctorDTO doctorDTO = DoctorDTOMother.returnOne();
        doctorDTO.setName("pepito");
        Mockito.when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(new DoctorEntity());
        doctorService.edit(1L, new DoctorDTO());
        verify(doctorRepository,times(1) ).save(any());
    }

    @Test
    public void delete(){
        DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
        doctorService.delete(1L);
        verify(doctorRepository, times(1)).deleteById(any());
    }
}
