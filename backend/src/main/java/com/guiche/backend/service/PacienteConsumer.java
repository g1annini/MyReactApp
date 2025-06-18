package com.guiche.backend.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PacienteConsumer {

    @KafkaListener(topics = "fila-pacientes", groupId = "painel-group")
    public void consumirPaciente(String mensagemJson) {
        System.out.println("Mensagem recebida do Kafka:");
        System.out.println(mensagemJson);

        // Aqui você pode desserializar o JSON se quiser:
        // ObjectMapper mapper = new ObjectMapper();
        // PacienteDTO paciente = mapper.readValue(mensagemJson, PacienteDTO.class);
    }
}