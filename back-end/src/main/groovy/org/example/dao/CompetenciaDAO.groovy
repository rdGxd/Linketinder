package org.example.dao

import org.example.mapper.CompetenciaPreparedStatement
import org.example.model.Competencia
import org.example.repository.ICrud

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciaDAO implements ICrud<Competencia> {
    private final Connection connection

    CompetenciaDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Competencia> listar() {
        String sql = "SELECT * FROM competencias"
        List<Competencia> competencias = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            while (rs.next()) {
                competencias.add(new Competencia(
                        id: rs.getInt("id"),
                        nomeCompetencia: rs.getString("nome_competencia")
                ))
            }
        } catch (SQLException e) {
            e.printStackTrace()
        }

        return competencias
    }

    @Override
    void inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias (nome_competencia) VALUES (?)"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            CompetenciaPreparedStatement.setEntityOnDb(competencia, stmt)
            stmt.executeUpdate()

        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void atualizar(Competencia competencia, int id) {
        String sql = "UPDATE competencias SET nome_competencia = ? WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(2, id)
            CompetenciaPreparedStatement.setEntityOnDb(competencia, stmt)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void deletar(int id) {
        String sql = "DELETE FROM competencias WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

}
