package org.example.controller

import groovy.json.JsonSlurper
import org.example.model.Competencia
import org.example.service.CompetenciaService

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "CompetenciasController", urlPatterns = ["/competencias/*"])
class CompetenciasController extends HttpServlet {

    private final CompetenciaService competenciaService
    private final JsonSlurper slurper

    CompetenciasController() {
        this.competenciaService = new CompetenciaService()
        this.slurper = new JsonSlurper()

    }

    CompetenciasController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService
        this.slurper = new JsonSlurper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        def competenciaMapper = this.slurper.parse(req.getReader()) as Map
        Competencia competencia = new Competencia(competenciaMapper)
        competenciaService.inserir(competencia)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

}
