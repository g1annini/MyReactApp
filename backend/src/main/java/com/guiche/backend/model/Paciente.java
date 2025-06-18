package com.guiche.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Long getId() {
        this.id = id;
    }

    public String getNome() {
        this.nome = nome;
    }

    public String getCpf() {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        this.dataNascimento = dataNascimento;
    }

    // getters e setters
}