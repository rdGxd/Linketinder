package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.service.EmpresaService
import org.example.model.Empresa

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

@WebServlet(name = "EmpresasController", urlPatterns = ["/empresas/*"])
class EmpresasController extends HttpServlet {

    private final EmpresaService empresaService
    private final ObjectMapper objectMapper

    EmpresasController() {
        this.objectMapper = new ObjectMapper()
        this.empresaService = new EmpresaService()
    }

    EmpresasController(EmpresaService empresaService) {
        this.empresaService = empresaService
        this.objectMapper = new ObjectMapper()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Empresa empresa = objectMapper.readValue(req.getReader(), Empresa.class)
        empresaService.inserir(empresa)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }
}