package org.example.mapper


import org.example.model.Empresa

import java.sql.PreparedStatement
import java.sql.SQLException

class EmpresaPreparedStatement {
    static void setEntityOnDb(Empresa empresa, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, empresa.nomeEmpresa)
        stmt.setString(2, empresa.cnpj)
        stmt.setString(3, empresa.emailCorporativo)
        stmt.setString(4, empresa.descricaoEmpresa)
        stmt.setString(5, empresa.pais)
        stmt.setString(6, empresa.cep)
        stmt.setString(7, empresa.senha)
    }
}
