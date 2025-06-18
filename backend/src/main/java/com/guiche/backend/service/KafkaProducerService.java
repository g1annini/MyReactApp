package com.guiche.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guiche.backend.dto.PacienteDTO;
import com.guiche.backend.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarPacienteDTO(String topico, Paciente paciente) {
        try {
            PacienteDTO dto = new PacienteDTO(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getDataNascimento());
            String json = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send(topico, json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar PacienteDTO", e);
        }
    }
}