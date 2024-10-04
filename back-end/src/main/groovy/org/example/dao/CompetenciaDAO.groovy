package org.example.dao

import org.example.model.Competencia
import org.example.repository.CRUDMethods

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciaDAO implements CRUDMethods<Competencia> {
    private Connection connection

    CompetenciaDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Competencia> listar() {
        String sql = "SELECT * FROM competencias"
        Competencia competencia = null
        List<Competencia> competencias = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            while (rs.next()) {
                competencia = new Competencia(
                        id: rs.getInt("id"),
                        nomeCompetencia: rs.getString("nome_competencia")
                )
                competencias.add(competencia)
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
            setEntityOnDb(competencia, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void atualizar(Competencia competencia, int id) {
        String sql = "UPDATE competencias SET nome_competencia = ? WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(2, id)
            setEntityOnDb(competencia, stmt)
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

    @Override
    void setEntityOnDb(Competencia competencia, PreparedStatement stmt) {
        stmt.setString(1, competencia.nomeCompetencia)
        stmt.executeUpdate()
    }
}
