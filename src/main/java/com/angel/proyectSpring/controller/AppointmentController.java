package com.angel.proyectSpring.controller;

import com.angel.proyectSpring.controller.dto.AppointmentDTO;
import com.angel.proyectSpring.service.AppointmentService;
import com.angel.proyectSpring.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService AppointmentService ;
    @GetMapping()
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        return new ResponseEntity<>(AppointmentService.findAll(), HttpStatus.OK);

    }
    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody AppointmentDTO appointment) {
        AppointmentDTO appointmentCreate = this.AppointmentService.create(appointment);
        return ResponseEntity.ok(appointmentCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody AppointmentDTO appointment) {
        if(appointment==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(AppointmentService.edit(id, appointment));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        AppointmentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}

