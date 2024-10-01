package org.example.controller

import org.example.dao.EmpresaDAO
import org.example.model.Empresa
import org.example.repository.DbConnection

class EmpresasController {

    private EmpresaDAO empresaDAO = new EmpresaDAO(DbConnection.conectar())

    List<Empresa> listar() {
        return empresaDAO.listar()
    }

    void inserir(Empresa newEmpresa) {
        empresaDAO.inserir(newEmpresa)
    }

    void atualizar(Empresa newEmpresa, int id) {
        empresaDAO.atualizar(newEmpresa, id)
    }

    void deletar(int id) {
        empresaDAO.deletar(id)
    }
}
