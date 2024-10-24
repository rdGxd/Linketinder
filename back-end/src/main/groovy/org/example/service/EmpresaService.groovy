package org.example.service

import org.example.dao.EmpresaDAO
import org.example.model.Empresa
import org.example.utils.ConnectionFactory

class EmpresaService {

    private final EmpresaDAO empresaDAO

    EmpresaService() {
        this.empresaDAO = new EmpresaDAO(ConnectionFactory.getConnectionInstancePostgres())
    }

    EmpresaService(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    List<Empresa> listar() {
        return empresaDAO.listar()
    }

    void inserir(Empresa newUser) {
        empresaDAO.inserir(newUser)
    }

    void atualizar(Empresa newUser, int id) {
        empresaDAO.atualizar(newUser, id)
    }

    void deletar(int id) {
        empresaDAO.deletar(id)
    }
}