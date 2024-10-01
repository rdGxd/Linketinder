package org.example.controller

import org.example.dao.VagaDAO
import org.example.model.Vaga
import org.example.repository.DbConnection

class VagaController {

    private VagaDAO vagaDAO = new VagaDAO(DbConnection.conectar())


    List<Vaga> listar() {
        return vagaDAO.listar()
    }

    void inserir(Vaga newVaga) {
        vagaDAO.inserir(newVaga)
    }

    void atualizar(Vaga newVaga, int idVaga) {
        vagaDAO.atualizar(newVaga, idVaga)
    }

    void deletar(int idVaga) {
        vagaDAO.deletar(idVaga)
    }
}
