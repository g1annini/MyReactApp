import { useState } from "react";
import styled from "styled-components";
import axios from "axios";

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 12px;
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 24px;
`;

const Input = styled.input`
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
`;

const Button = styled.button`
  background-color: #1976d2;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;

  &:hover {
    background-color: #1565c0;
  }
`;

export default function FormularioPaciente({ aoCadastrar }) {
  const [nome, setNome] = useState("");
  const [cpf, setCpf] = useState("");
  const [dataNasc, setDataNasc] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const novoPaciente = { nome, cpf, dataNasc };

    axios
      .post("http://localhost:8080/api/pacientes", novoPaciente)
      .then(() => {
        setNome("");
        setCpf("");
        setDataNasc("");
        if (aoCadastrar) aoCadastrar(); // atualiza a lista
      })
      .catch((err) => {
        alert("Erro ao cadastrar paciente.");
        console.error(err);
      });
  };

  return (
    <Form onSubmit={handleSubmit}>
      <h2>Cadastrar Novo Paciente</h2>
      <Input
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
        required
      />
      <Input
        type="text"
        placeholder="CPF"
        value={cpf}
        onChange={(e) => setCpf(e.target.value)}
        required
      />
      <Input
        type="date"
        value={dataNasc}
        onChange={(e) => setDataNasc(e.target.value)}
        required
      />
      <Button type="submit">Cadastrar</Button>
    </Form>
  );
}