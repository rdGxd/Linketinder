package org.example.model


class Candidato {

    String nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricaoPessoal, senha, id

    Candidato(String nome, String sobrenome, String dataNascimento, String email, String cpf, String pais, String cep, String descricaoPessoal, String senha) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.dataNascimento = dataNascimento
        this.email = email
        this.cpf = cpf
        this.pais = pais
        this.cep = cep
        this.descricaoPessoal = descricaoPessoal
        this.senha = senha
    }

    Candidato(Map params) {
        this.id = params.id ?: 0
        this.nome = params.nome
        this.sobrenome = params.sobrenome
        this.dataNascimento = params.dataNascimento
        this.email = params.email
        this.cpf = params.cpf
        this.pais = params.pais
        this.cep = params.cep
        this.descricaoPessoal = params.descricaoPessoal
        this.senha = params.senha
    }

    Candidato() {}

    String toString() {
        return "Candidato(id: $id, nome: $nome, sobrenome: $sobrenome, dataNascimento: $dataNascimento, email: $email, cpf: $cpf, pais: $pais, cep: $cep, descricaoPessoal: $descricaoPessoal, senha: $senha)"
    }
}
