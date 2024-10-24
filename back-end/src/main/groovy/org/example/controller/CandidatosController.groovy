package org.example.controller

import groovy.json.JsonSlurper
import org.example.service.CandidatoService
import org.example.model.Candidato

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "CandidatosController", urlPatterns = ["/candidatos/*"])
class CandidatosController extends HttpServlet {

    private final CandidatoService candidatoService
    private final JsonSlurper slurper

    CandidatosController() {
        this.slurper = new JsonSlurper()
        this.candidatoService = new CandidatoService()
    }

    CandidatosController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService
        this.slurper = new JsonSlurper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        def candidatoMap = slurper.parse(req.getReader()) as Map
        Candidato candidato = new Candidato(candidatoMap)
        candidatoService.inserir(candidato)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }
}