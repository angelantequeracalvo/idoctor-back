package com.angel.idoctor.service;

import com.angel.idoctor.controller.dto.PatientDTO;
import com.angel.idoctor.model.PatientEntity;
import com.angel.idoctor.repository.PatientRepository;
import com.angel.idoctor.service.impl.PatientServiceImpl;
import com.angel.idoctor.utils.objectMothers.PatientDTOMother;
import com.angel.idoctor.utils.objectMothers.PatientEntityMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void shouldReturnAllPatientTest() {
        List<PatientEntity> patientEntityList = PatientEntityMother.returnList();
        List<PatientDTO> patientDTOList = PatientDTOMother.returnList();
        Mockito.when(patientRepository.findAll()).thenReturn(patientEntityList);
        final List<PatientDTO> result= patientService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(patientDTOList, result);
        Mockito.verify(patientRepository).findAll();
    }

    @Test
    public void shouldCreateNewPatientTest() {
        PatientEntity patientEntity = PatientEntityMother.returnOne();
        PatientDTO patientDTO = PatientDTOMother.returnOne();
        when(patientRepository.save(any(PatientEntity.class))).thenReturn(new PatientEntity());
        patientService.create(new PatientDTO());
        verify(patientRepository,times(1) ).save(any());
    }

    @Test
    public void shouldUpdatePatientTest(){

        PatientEntity patientEntity = PatientEntityMother.returnOne();
        patientEntity.setName("pepito");
        PatientDTO patientDTO = PatientDTOMother.returnOne();
        patientDTO.setName("pepito");
        when(patientRepository.save(any(PatientEntity.class))).thenReturn(new PatientEntity());
        patientService.edit(1L, new PatientDTO());
        verify(patientRepository,times(1) ).save(any());
    }

    @Test
    public void delete(){
        PatientEntity patientEntity = PatientEntityMother.returnOne();
        patientService.delete(1L);
        verify(patientRepository, times(1)).deleteById(any());
    }
}
