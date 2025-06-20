package com.guiche.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    @Column(unique = true, length = 11)
    private String cpf;

    @Past(message = "Data de nascimento deve estar no passado")
    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    @Column(name = "data_cadastro")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataCadastro;

    @PrePersist
    protected void onCreate() {this.dataCadastro = LocalDateTime.now();}

    //Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNasc() { return dataNasc; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }

    //Setters
    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setDataNasc(LocalDate dataNasc) {this.dataNasc = dataNasc;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return id != null && id.equals(paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}