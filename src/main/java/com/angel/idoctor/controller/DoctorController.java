package com.angel.idoctor.controller;

import com.angel.idoctor.controller.dto.DoctorDTO;
import com.angel.idoctor.service.DoctorService;
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
@CrossOrigin

public class DoctorController {
    private final DoctorService doctorService;
    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getAll() {
        return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody DoctorDTO doctor) {
        DoctorDTO doctorCreate = this.doctorService.create(doctor);
        return ResponseEntity.ok(doctorCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody DoctorDTO doctor) {
        if(doctor==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(doctorService.edit(id, doctor));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        doctorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}


