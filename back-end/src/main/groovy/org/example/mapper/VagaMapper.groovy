package org.example.mapper

import org.example.model.Vaga

import java.sql.PreparedStatement
import java.sql.SQLException

class VagaMapper {
    static void setEntityOnDb(Vaga vaga, PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, vaga.idEmpresa as int)
        stmt.setString(2, vaga.nomeVaga)
        stmt.setString(3, vaga.descricaoVaga)
        stmt.setString(4, vaga.local)
        stmt.executeUpdate()
    }
}
