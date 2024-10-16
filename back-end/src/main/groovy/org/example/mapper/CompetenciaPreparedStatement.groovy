package org.example.mapper

import org.example.model.Competencia

import java.sql.PreparedStatement
import java.sql.SQLException

class CompetenciaPreparedStatement {
    static void setEntityOnDb(Competencia competencia, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, competencia.nomeCompetencia)
    }
}
