package com.angel.proyectSpring.controller;

import com.angel.proyectSpring.controller.dto.DoctorDTO;
import com.angel.proyectSpring.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
@Validated
public class DoctorController {
    private final DoctorService doctorService;
    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getAll() {
        return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody DoctorDTO doctor) {
        this.doctorService.create(doctor);
       // return new ResponseEntity<>(HttpStatus.CREATED);
        return ResponseEntity.ok("is create");
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody DoctorDTO doctor) {
        doctorService.edit(id, doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        doctorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}


