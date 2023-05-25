package com.angel.idoctor.controller;

import com.angel.idoctor.controller.dto.AppointmentDTO;
import com.angel.idoctor.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService ;
    @GetMapping()
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        List<AppointmentDTO> appointmentDTOList =appointmentService.findAll();
        return ResponseEntity.ok(appointmentDTOList);

    }
    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody AppointmentDTO appointment) {
        AppointmentDTO appointmentCreate = this.appointmentService.create(appointment);
        return ResponseEntity.ok(appointmentCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") long id, @RequestBody AppointmentDTO appointment) {
        if(appointment==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(appointmentService.edit(id, appointment));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        appointmentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}

