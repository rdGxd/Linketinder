package org.example.controller


import org.example.dao.CompetenciaDAO
import org.example.model.Competencia

class CompetenciasController {


    private final CompetenciaDAO competenciaDAO

    CompetenciasController(CompetenciaDAO competenciaDAO) {
        this.competenciaDAO = competenciaDAO
    }

    List<Competencia> listar() {
        return competenciaDAO.listar()
    }

    void inserir(Competencia newVaga) {
        competenciaDAO.inserir(newVaga)
    }

    void atualizar(Competencia newVaga, int idCompetencia) {
        competenciaDAO.atualizar(newVaga, idCompetencia)
    }

    void deletar(int id) {
        competenciaDAO.deletar(id)
    }
}
