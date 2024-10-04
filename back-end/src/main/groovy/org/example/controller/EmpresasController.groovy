package org.example.controller


import org.example.dao.EmpresaDAO
import org.example.model.Empresa

class EmpresasController {

    private final EmpresaDAO empresaDAO

    EmpresasController(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    List<Empresa> listar() { return empresaDAO.listar() }

    void inserir(Empresa newEmpresa) { empresaDAO.inserir(newEmpresa) }

    void atualizar(Empresa newEmpresa, int id) { empresaDAO.atualizar(newEmpresa, id) }

    void deletar(int id) { empresaDAO.deletar(id) }
}
