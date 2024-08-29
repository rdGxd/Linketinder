package org.example.repository

import groovy.transform.ToString

@ToString
abstract class Pessoa {
    String nome
    String email
    String estado
    String cep
    String descricao
    List<String> competencias

    Pessoa(String nome, String email, String estado, String cep, String descricao, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
    }
}