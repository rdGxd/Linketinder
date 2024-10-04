package org.example.controller


import org.example.dao.VagaDAO
import org.example.model.Vaga

class VagaController {


    private final VagaDAO vagaDAO

    VagaController(VagaDAO vagaDAO) {
        this.vagaDAO = vagaDAO
    }

    List<Vaga> listar() { return vagaDAO.listar() }

    void inserir(Vaga newVaga) { vagaDAO.inserir(newVaga) }

    void atualizar(Vaga newVaga, int idVaga) { vagaDAO.atualizar(newVaga, idVaga) }

    void deletar(int idVaga) { vagaDAO.deletar(idVaga) }
}
