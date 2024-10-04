package org.example.dao

import org.example.mapper.VagaMapper
import org.example.model.Vaga
import org.example.repository.IVaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO implements IVaga {
    private Connection connection

    VagaDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Vaga> listar() {
        String sql = "SELECT * FROM vagas"
        List<Vaga> vagas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            while (rs.next()) {
                vagas.add(new Vaga(
                        id: rs.getInt("id"),
                        idEmpresa: rs.getInt("id_empresa"),
                        nomeVaga: rs.getString("nome_vaga"),
                        descricaoVaga: rs.getString("descricao_vaga"),
                        local: rs.getString("local")
                ))
            }
        } catch (SQLException e) {
            e.printStackTrace()
        }
        return vagas
    }

    @Override
    void inserir(Vaga vaga) {
        String sql = """
            INSERT INTO vagas (id_empresa, nome_vaga, descricao_vaga, local)
            VALUES (?, ?, ?, ?)
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            VagaMapper.setEntityOnDb(vaga, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }

    }

    @Override
    void atualizar(Vaga vaga, int id) {
        String sql = """
            UPDATE vagas
            SET id_empresa = ?, nome_vaga = ?, descricao_vaga = ?, local = ?
            WHERE id = ?
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(5, id)
            VagaMapper.setEntityOnDb(vaga, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void deletar(int id) {
        String sql = "DELETE FROM vagas WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }


}