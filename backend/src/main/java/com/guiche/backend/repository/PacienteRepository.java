package com.guiche.backend.repository;

import com.guiche.backend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente save(Paciente paciente);
}