package com.angel.proyectSpring.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDTO {

    private String nombre;
    private String alias;
    private Integer edad;
    private Long id;
}

