package com.guiche.backend.controller;

import com.guiche.backend.model.Paciente;
import com.guiche.backend.repository.PacienteRepository;
import com.guiche.backend.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepo;

    @Autowired
    private KafkaProducerService kafkaProducer;

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteRepo.save(paciente);
        kafkaProducer.enviarPacienteDTO("fila-pacientes", salvo);
        return ResponseEntity.ok(salvo);
    }
}