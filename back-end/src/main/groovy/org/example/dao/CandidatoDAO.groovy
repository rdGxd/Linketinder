package org.example.dao

import org.example.mapper.CandidatoMapper
import org.example.model.Candidato
import org.example.repository.ICrud

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO implements ICrud<Candidato> {
    private Connection connection

    CandidatoDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Candidato> listar() {
        String sql = 'SELECT * FROM candidatos'
        List<Candidato> candidatos = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                candidatos.add(new Candidato(
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
                ))
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
            CandidatoMapper.setEntityOnDb(candidato, stmt)
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
            CandidatoMapper.setEntityOnDb(candidato, stmt)
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
}