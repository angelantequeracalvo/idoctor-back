package com.angel.proyectSpring.service;

import com.angel.proyectSpring.controller.dto.DoctorDTO;
import com.angel.proyectSpring.model.DoctorEntity;
import com.angel.proyectSpring.repository.DoctorRepository;
import com.angel.proyectSpring.service.impl.DoctorServiceImpl;
import com.angel.proyectSpring.utils.objectMothers.DoctorDTOMother;
import com.angel.proyectSpring.utils.objectMothers.DoctorEntityMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

     // Mockito.when(doctorMapper.entityToDtoList(doctorEntityList)).thenReturn(doctorDTOList);
      Mockito.when(doctorRepository.findAll()).thenReturn(doctorEntityList);

      final List<DoctorDTO> result= doctorService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(doctorDTOList, result);
        Mockito.verify(doctorRepository).findAll();
        //Mockito.verify(doctorMapper).entityToDtoList(doctorEntityList);

    }

    @Test
    public void shouldCreateNewDoctorTest() {

       DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
       DoctorDTO doctorDTO = DoctorDTOMother.returnOne();

       // Mockito.when(doctorMapper.entityToDto(doctorEntity)).thenReturn(doctorDTO);
        when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(new DoctorEntity());

        doctorService.create(new DoctorDTO());

        verify(doctorRepository,times(1) ).save(any());

    }

    @Test
    public void shouldUpdateDoctorTest(){

        DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
        doctorEntity.setNombre("pepito");

        DoctorDTO doctorDTO = DoctorDTOMother.returnOne();
        doctorDTO.setNombre("pepito");
        Mockito.when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(new DoctorEntity());
      //  Mockito.when(doctorMapper.entityToDto(doctorEntity)).thenReturn(doctorDTO);

        doctorService.edit(1L, new DoctorDTO());

        verify(doctorRepository,times(1) ).save(any());
    }

    @Test
    public void delete(){
        DoctorEntity doctorEntity = DoctorEntityMother.returnOne();
       // DoctorEntity deleteOne = new DoctorEntity();
       // Mockito.when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctorEntity));
        //deleteOne.setId(1L);
        doctorService.delete(1L);

        verify(doctorRepository, times(1)).deleteById(any());
    }

}
