package org.example.service

import org.example.dao.CandidatoDAO
import org.example.model.Candidato
import org.example.utils.ConnectionFactory

class CandidatoService {

    private final CandidatoDAO candidatoDAO

    CandidatoService() {
        this.candidatoDAO = new CandidatoDAO(ConnectionFactory.getConnectionInstancePostgres())
    }

    CandidatoService(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO
    }

    List<Candidato> listar() {
        return candidatoDAO.listar()
    }

    void inserir(Candidato newUser) {
        candidatoDAO.inserir(newUser)
    }

    void atualizar(Candidato newUser, int id) {
        candidatoDAO.atualizar(newUser, id)
    }

    void deletar(int id) {
        candidatoDAO.deletar(id)
    }
}