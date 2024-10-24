package org.example.controller

import groovy.json.JsonSlurper
import org.example.model.Vaga
import org.example.service.VagaService

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "VagasController", urlPatterns = ["/vagas/*"])
class VagasController extends HttpServlet {

    private final VagaService vagaService
    private final JsonSlurper slurper

    VagasController() {
        this.slurper = new JsonSlurper()
        this.vagaService = new VagaService()
    }

    VagasController(VagaService vagaService) {
        this.vagaService = vagaService
        this.slurper = new JsonSlurper()

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        def vagaMapper = this.slurper.parse(req.getReader()) as Map
        Vaga vaga = new Vaga(vagaMapper)
        vagaService.inserir(vaga)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

}
