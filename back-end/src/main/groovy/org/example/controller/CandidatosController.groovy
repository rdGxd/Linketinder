package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.service.CandidatoService
import org.example.model.Candidato

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

@WebServlet(name = "CandidatosController", urlPatterns = ["/candidatos/*"])
class CandidatosController extends HttpServlet {

    private final CandidatoService candidatoService
    private final ObjectMapper objectMapper

    CandidatosController() {
        this.objectMapper = new ObjectMapper()
        this.candidatoService = new CandidatoService()
    }

    CandidatosController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService
        this.objectMapper = new ObjectMapper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidato candidato = objectMapper.readValue(req.getReader(), Candidato.class)
        candidatoService.inserir(candidato)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }
}