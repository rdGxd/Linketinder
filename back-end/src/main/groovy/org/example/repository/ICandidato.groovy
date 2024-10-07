package org.example.repository

import org.example.model.Candidato

interface ICandidato extends ICrud<Candidato> {

    List<Candidato> listar()

    void inserir(Candidato candidato)

    void atualizar(Candidato candidato, int id)

    void deletar(int id)

}