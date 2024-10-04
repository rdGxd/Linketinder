package org.example.repository

import org.example.model.Competencia

interface ICompetencia {

    List<Competencia> listar()

    void inserir(Competencia competencia)

    void atualizar(Competencia competencia, int id)

    void deletar(int id)

}