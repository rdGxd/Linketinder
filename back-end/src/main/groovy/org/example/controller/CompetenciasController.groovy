package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
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
    private final ObjectMapper objectMapper

    CompetenciasController() {
        this.objectMapper = new ObjectMapper()
        this.competenciaService = new CompetenciaService()
    }

    CompetenciasController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService
        this.objectMapper = new ObjectMapper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Competencia competencia = objectMapper.readValue(req.getReader(), Competencia.class)
        competenciaService.inserir(competencia)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

}
