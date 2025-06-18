package com.guiche.backend.dto;

import java.time.LocalDate;

public class PacienteAtualizacaoDTO {
    private String nome;
    private String cpf;
    private LocalDate dataNasc;


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }
}
