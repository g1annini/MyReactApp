package com.guiche.backend.dto;

import com.guiche.backend.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class PacienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public PacienteDTO(Long id, String nome, String cpf, LocalDate dataNascimento ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    /* Getters e setters */
}
