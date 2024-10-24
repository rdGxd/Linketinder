package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
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
    private final ObjectMapper objectMapper

    VagasController() {
        this.objectMapper = new ObjectMapper()
        this.vagaService = new VagaService()
    }

    VagasController(VagaService vagaService) {
        this.vagaService = vagaService
        this.objectMapper = new ObjectMapper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vaga vaga = objectMapper.readValue(req.getReader(), Vaga.class)
        vagaService.inserir(vaga)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

}
