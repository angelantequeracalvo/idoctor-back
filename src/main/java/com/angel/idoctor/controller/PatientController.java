package com.angel.idoctor.controller;

import com.angel.idoctor.controller.dto.PatientDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.angel.idoctor.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
@Validated
@CrossOrigin

public class PatientController {

    private final PatientService patientService;


    @GetMapping()
    public ResponseEntity<List<PatientDTO>> findAll() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody PatientDTO patient) {
        PatientDTO patientCreate = this.patientService.create(patient);
        return ResponseEntity.ok(patientCreate);

    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody PatientDTO patient) {
        if(patient==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(patientService.edit(id, patient));
        }
    }
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") Long id){
           this.patientService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }

    }

