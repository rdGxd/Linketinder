package org.example.repository

interface ICrud<T> {

    List<T> listar()

    void inserir(T obj)

    void atualizar(T obj, int id)

    void deletar(int id)

}