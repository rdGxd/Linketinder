package org.example.dao

import org.example.model.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO {
    private Connection connection

    VagaDAO(Connection connection) {
        this.connection = connection
    }


    void listar() {
        String sql = "SELECT * FROM vagas"
        Vaga vaga = null
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            List<Vaga> vagas = new ArrayList<>()
            while (rs.next()) {
                vaga = new Vaga(
                        id: rs.getInt("id"),
                        idEmpresa: rs.getInt("id_empresa"),
                        nomeVaga: rs.getString("nome_vaga"),
                        descricaoVaga: rs.getString("descricao_vaga"),
                        local: rs.getString("local")
                )
                vagas.add(vaga)
            }
            println(vagas)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    // Criar vaga
    void inserir(Vaga vaga) {
        String sql = """
            INSERT INTO vagas (id_empresa, nome_vaga, descricao_vaga, local)
            VALUES (?, ?, ?, ?)
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vaga.idEmpresa as int)
            stmt.setString(2, vaga.nomeVaga)
            stmt.setString(3, vaga.descricaoVaga)
            stmt.setString(4, vaga.local)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }

    }


    // Atualizar vaga
    void atualizar(Vaga vaga, int id) {
        String sql = """
            UPDATE vagas
            SET id_empresa = ?, nome_vaga = ?, descricao_vaga = ?, local = ?
            WHERE id = ?
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vaga.idEmpresa as int)
            stmt.setString(2, vaga.nomeVaga)
            stmt.setString(3, vaga.descricaoVaga)
            stmt.setString(4, vaga.local)
            stmt.setInt(5, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }


    // Deletar vaga
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