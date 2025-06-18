package com.guiche.backend.controller;

import com.guiche.backend.dto.PacienteAtualizacaoDTO;
import com.guiche.backend.model.Paciente;
import com.guiche.backend.repository.PacienteRepository;
import com.guiche.backend.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Paciente> buscarPorCpf(@PathVariable String cpf) {
        return pacienteRepository.findByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    System.out.println("ANTES: " + paciente);
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setDataNasc(pacienteAtualizado.getDataNasc());
                    System.out.println("DEPOIS: " + paciente);
                    return ResponseEntity.ok(pacienteRepository.save(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> atualizarParcialmente(@PathVariable Long id,
                                                          @RequestBody PacienteAtualizacaoDTO dto) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    if (dto.getNome() != null) paciente.setNome(dto.getNome());
                    if (dto.getCpf() != null) paciente.setCpf(dto.getCpf());
                    if (dto.getDataNasc() != null) paciente.setDataNasc(dto.getDataNasc());
                    return ResponseEntity.ok(pacienteRepository.save(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}