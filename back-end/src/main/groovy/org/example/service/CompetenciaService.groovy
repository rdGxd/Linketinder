package org.example.service

import org.example.dao.CompetenciaDAO
import org.example.model.Competencia
import org.example.utils.ConnectionFactory

class CompetenciaService {

    private final CompetenciaDAO competenciaDAO

    CompetenciaService() {
        this.competenciaDAO = new CompetenciaDAO(ConnectionFactory.getConnectionInstancePostgres())
    }

    CompetenciaService(CompetenciaDAO competenciaDAO) {
        this.competenciaDAO = competenciaDAO
    }

    List<Competencia> listar() {
        return competenciaDAO.listar()
    }

    void inserir(Competencia newUser) {
        competenciaDAO.inserir(newUser)
    }

    void atualizar(Competencia newUser, int id) {
        competenciaDAO.atualizar(newUser, id)
    }

    void deletar(int id) {
        competenciaDAO.deletar(id)
    }
}