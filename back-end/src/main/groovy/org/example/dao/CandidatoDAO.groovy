package org.example.dao

import org.example.model.Candidato
import org.example.repository.CRUDMethods

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO implements CRUDMethods<Candidato> {
    private Connection connection

    CandidatoDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Candidato> listar() {
        String sql = 'SELECT * FROM candidatos'
        Candidato candidato = null
        List<Candidato> candidatos = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            while (rs.next()) {
                candidato = new Candidato(
                        id: rs.getInt("id"),
                        nome: rs.getString("nome"),
                        sobrenome: rs.getString("sobrenome"),
                        dataNascimento: rs.getDate("data_nascimento").toLocalDate(),
                        email: rs.getString("email"),
                        cpf: rs.getString("cpf"),
                        pais: rs.getString("pais"),
                        cep: rs.getString("cep"),
                        descricaoPessoal: rs.getString("descricao_pessoal"),
                        senha: rs.getString("senha")
                )
                candidatos.add(candidato)
            }
        } catch (SQLException e) {
            e.printStackTrace()
        }
        return candidatos
    }

    @Override
    void inserir(Candidato candidato) {
        String sql = '''
            INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, cep, descricao_pessoal, senha)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        '''
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setEntityOnDb(candidato, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void atualizar(Candidato candidato, int id) {
        String sql = '''
            UPDATE candidatos SET nome = ?, sobrenome = ?, data_nascimento = ?, email = ?, cpf = ?, pais = ?, cep = ?, descricao_pessoal = ?, senha = ?
            WHERE id = ?
        '''
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(10, id)
            setEntityOnDb(candidato, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void deletar(int id) {
        String sql = 'DELETE FROM candidatos WHERE id = ?'
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void setEntityOnDb(Candidato candidato, PreparedStatement stmt) {
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
