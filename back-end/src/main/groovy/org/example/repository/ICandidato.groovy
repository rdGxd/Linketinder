package org.example.repository

import org.example.model.Candidato

interface ICandidato {

    List<Candidato> listar()

    void inserir(Candidato candidato)

    void atualizar(Candidato candidato, int id)

    void deletar(int id)

}