package org.example.mapper

import org.example.model.Candidato

import java.sql.PreparedStatement
import java.sql.SQLException

class CandidatoMapper {
    static void setEntityOnDb(Candidato candidato, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, candidato.nome)
        stmt.setString(2, candidato.sobrenome)
        stmt.setDate(3, java.sql.Date.valueOf(candidato.dataNascimento))
        stmt.setString(4, candidato.email)
        stmt.setString(5, candidato.cpf)
        stmt.setString(6, candidato.pais)
        stmt.setString(7, candidato.cep)
        stmt.setString(8, candidato.descricaoPessoal)
        stmt.setString(9, candidato.senha)
        stmt.executeUpdate()
    }
}