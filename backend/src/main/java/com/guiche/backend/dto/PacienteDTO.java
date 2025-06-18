package com.guiche.backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;

    public PacienteDTO(Long id, String nome, String cpf, LocalDate dataNascimento, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }

    /* Getters e setters */
}
