package com.angel.proyectSpring.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDTO {

    private String name;
    private String surname;
    private Integer age;
    private Long id;
}

