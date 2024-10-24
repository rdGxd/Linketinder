package org.example.controller

import groovy.json.JsonSlurper
import org.example.service.EmpresaService
import org.example.model.Empresa

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "EmpresasController", urlPatterns = ["/empresas/*"])
class EmpresasController extends HttpServlet {

    private final EmpresaService empresaService
    private final JsonSlurper slurper

    EmpresasController() {
        this.empresaService = new EmpresaService()
        this.slurper = new JsonSlurper()
    }

    EmpresasController(EmpresaService empresaService) {
        this.empresaService = empresaService
        this.slurper = new JsonSlurper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        def empresaMapper = this.slurper.parse(req.getReader()) as Map
        Empresa empresa = new Empresa(empresaMapper)
        empresaService.inserir(empresa)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }
}