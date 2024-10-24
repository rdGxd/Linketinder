package org.example.service

import org.example.dao.VagaDAO
import org.example.model.Vaga
import org.example.utils.ConnectionFactory

class VagaService {

    private final VagaDAO vagaDAO

    VagaService() {
        this.vagaDAO = new VagaDAO(ConnectionFactory.getConnectionInstancePostgres())
    }

    VagaService(VagaDAO vagaDAO) {
        this.vagaDAO = vagaDAO
    }

    List<Vaga> listar() {
        return vagaDAO.listar()
    }

    void inserir(Vaga newUser) {
        vagaDAO.inserir(newUser)
    }

    void atualizar(Vaga newUser, int id) {
        vagaDAO.atualizar(newUser, id)
    }

    void deletar(int id) {
        vagaDAO.deletar(id)
    }
}