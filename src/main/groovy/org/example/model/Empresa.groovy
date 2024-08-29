package org.example.model

import org.example.repository.Pessoa


class Empresa extends Pessoa {
    String cnpj
    String pais

    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias) {
        super(nome, email, estado, cep, descricao, competencias)
        this.cnpj = cnpj
        this.pais = pais
    }

    @Override
    String toString() {
        return "${super.toString()}, CNPJ: ${cnpj}, País: ${pais}, Competências: ${competencias.join(', ')}"
    }
}
