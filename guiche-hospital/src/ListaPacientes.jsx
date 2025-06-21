import { useEffect, useState } from "react";
import axios from "axios";
import styled from "styled-components";

const ListaContainer = styled.div`
  padding: 20px;
`;

const PacienteItem = styled.li`
  background-color: #f1f1f1;
  margin-bottom: 12px;
  padding: 12px;
  border-radius: 6px;
  list-style: none;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
`;

export default function ListaPacientes() {
  const [pacientes, setPacientes] = useState([]);

  useEffect(() => {
  console.log("Buscando pacientes...");
  axios
    .get("http://localhost:8080/api/pacientes")
    .then((res) => setPacientes(res.data))
    .catch((err) => console.error("Erro ao buscar pacientes:", err));
}, []);

  return (
    <ListaContainer>
      <h2>Pacientes Cadastrados</h2>
      <ul>
        {pacientes.map((paciente) => (
          <PacienteItem key={paciente.id}>
            <strong>{paciente.nome}</strong> — {paciente.cpf}<br />
            Nasc.: {paciente.dataNascimento}
          </PacienteItem>
        ))}
      </ul>
    </ListaContainer>
  );
}