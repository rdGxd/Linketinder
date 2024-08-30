package org.example.model

import org.example.repository.Pessoa

class Candidato extends Pessoa {
    String cpf
    int idade

    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, email, estado, cep, descricao, competencias)
        this.cpf = cpf
        this.idade = idade
    }

    @Override
    String toString() {
        return "${super.toString()}, CPF: ${cpf}, Idade: ${idade}, Competências: ${competencias.join(', ')}"
    }
}
