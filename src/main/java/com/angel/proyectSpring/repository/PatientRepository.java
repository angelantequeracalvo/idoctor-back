package com.angel.proyectSpring.repository;

import com.angel.proyectSpring.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
