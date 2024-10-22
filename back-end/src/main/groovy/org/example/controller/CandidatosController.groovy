package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper

import org.example.dao.CandidatoDAO
import org.example.model.Candidato
import org.example.utils.ConnectionFactory

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.sql.Connection

class CandidatosController  extends HttpServlet {

    private final CandidatoDAO candidatoDAO
    private final ObjectMapper objectMapper
    private final Connection connection = ConnectionFactory.getConnectionInstancePostgresHttp()

    CandidatosController() {
        this.objectMapper = new ObjectMapper()
        this.candidatoDAO = new CandidatoDAO(connection)
    }

    CandidatosController(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO
        this.objectMapper = new ObjectMapper()
    }

    List<Candidato> listar() {
        return candidatoDAO.listar()
    }

        void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidato candidato = objectMapper.readValue(req.getReader(), Candidato.class)
        candidatoDAO.inserir(candidato)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

    void inserir(Candidato newUser) {
        candidatoDAO.inserir(newUser)
    }

    void atualizar(Candidato newUser, int id) { candidatoDAO.atualizar(newUser, id) }

    void deletar(int id) { candidatoDAO.deletar(id) }
}
