package org.example.controller

import org.example.dao.CandidatoDAO
import org.example.model.Candidato

class CandidatosController {

    private final CandidatoDAO candidatoDAO

    CandidatosController(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO
    }

    List<Candidato> listar() {
        return candidatoDAO.listar()
    }

    void inserir(Candidato newUser) { candidatoDAO.inserir(newUser) }

    void atualizar(Candidato newUser, int id) { candidatoDAO.atualizar(newUser, id) }

    void deletar(int id) { candidatoDAO.deletar(id) }
}
