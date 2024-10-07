package org.example.repository

import org.example.model.Empresa

interface IEmpresa extends ICrud<Empresa> {

    List<Empresa> listar()

    void inserir(Empresa empresa)

    void atualizar(Empresa empresa, int id)

    void deletar(int id)

}