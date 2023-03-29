package com.angel.proyectSpring.controller;

import com.angel.proyectSpring.controller.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.angel.proyectSpring.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;


    @GetMapping()
    public ResponseEntity<List<PatientDTO>> findAll() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody PatientDTO patient) {
        this.patientService.create(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody PatientDTO patient) {
        this.patientService.edit(id, patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") Long id){
           this.patientService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }

    }

