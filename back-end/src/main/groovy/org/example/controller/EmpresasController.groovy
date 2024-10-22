package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.dao.EmpresaDAO
import org.example.model.Empresa
import org.example.utils.ConnectionFactory

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.sql.Connection

class EmpresasController  extends HttpServlet {

    private final ObjectMapper objectMapper
    private final EmpresaDAO empresaDAO
    private final Connection connection = ConnectionFactory.getConnectionInstancePostgresHttp()


    EmpresasController() {
        this.objectMapper = new ObjectMapper()
        this.empresaDAO = new EmpresaDAO(connection)
    }

    EmpresasController(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    List<Empresa> listar() { return empresaDAO.listar() }

    void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Empresa empresa = objectMapper.readValue(req.getReader(), Empresa.class)
        empresaDAO.inserir(empresa)
        resp.setStatus(HttpServletResponse.SC_CREATED)
    }

    void inserir(Empresa newEmpresa) { empresaDAO.inserir(newEmpresa) }

    void atualizar(Empresa newEmpresa, int id) { empresaDAO.atualizar(newEmpresa, id) }

    void deletar(int id) { empresaDAO.deletar(id) }
}
