package org.example.repository

import org.example.model.Vaga

interface IVaga {

    List<Vaga> listar()

    void inserir(Vaga vaga)

    void atualizar(Vaga vaga, int id)

    void deletar(int id)

}