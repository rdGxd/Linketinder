package org.example.dao


import org.example.model.Candidato
import spock.lang.Specification

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoDAOTest extends Specification {

    static Connection connection
    static PreparedStatement stmt

    def setup() {
        stmt = Mock()
        connection = Mock()
    }

    def "test inserir"() {
        given:
        CandidatoDAO dao = new CandidatoDAO(connection)
        Candidato candidato = new Candidato("John", "Doe", "1998-06-01", "john.doe@example.com", "12345678900", "Brasil", "12345678", "Descricao", "senha123")

        when:
        dao.inserir(candidato)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "John")
        1 * stmt.setString(2, "Doe")
        1 * stmt.setDate(3, java.sql.Date.valueOf("1998-06-01"))
        1 * stmt.setString(4, "john.doe@example.com")
        1 * stmt.setString(5, "12345678900")
        1 * stmt.setString(6, "Brasil")
        1 * stmt.setString(7, "12345678")
        1 * stmt.setString(8, "Descricao")
        1 * stmt.setString(9, "senha123")
        1 * stmt.executeUpdate()
    }

    def "test listar"() {
        given:
        ResultSet rs = Mock()
        CandidatoDAO dao = new CandidatoDAO(connection)

        when:
        List<Candidato> candidatos = dao.listar()

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.executeQuery() >> rs
        2 * rs.next() >> true >> false
        1 * rs.getInt("id") >> 1
        1 * rs.getString("nome") >> "John"
        1 * rs.getString("sobrenome") >> "Doe"
        1 * rs.getDate("data_nascimento") >> java.sql.Date.valueOf("1990-06-01")
        1 * rs.getString("email") >> "john.doe@example.com"
        1 * rs.getString("cpf") >> "12345678900"
        1 * rs.getString("pais") >> "Brasil"
        1 * rs.getString("cep") >> "12345678"
        1 * rs.getString("descricao_pessoal") >> "Descricao"
        1 * rs.getString("senha") >> "senha123"
        candidatos.size() == 1
        candidatos[0].nome == "John"
    }

    def "test atualizar"() {
        given:
        CandidatoDAO dao = new CandidatoDAO(connection)
        Candidato candidato = new Candidato("Rodrigo", "Doe", "1998-06-01", "john.doe@example.com", "12345678900", "Brasil", "12345678", "Descricao", "senha123")

        when:
        dao.atualizar(candidato, 1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "Rodrigo")
        1 * stmt.setString(2, "Doe")
        1 * stmt.setDate(3, java.sql.Date.valueOf("1998-06-01"))
        1 * stmt.setString(4, "john.doe@example.com")
        1 * stmt.setString(5, "12345678900")
        1 * stmt.setString(6, "Brasil")
        1 * stmt.setString(7, "12345678")
        1 * stmt.setString(8, "Descricao")
        1 * stmt.setString(9, "senha123")
        1 * stmt.setInt(10, 1)
        1 * stmt.executeUpdate()
    }

    def "test deletar"() {
        given:
        CandidatoDAO dao = new CandidatoDAO(connection)

        when:
        dao.deletar(1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.executeUpdate()
    }
}
