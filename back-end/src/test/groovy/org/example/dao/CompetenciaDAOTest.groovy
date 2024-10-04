package org.example.dao

import org.example.model.Competencia
import spock.lang.Specification

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAOTest extends Specification {

    static Connection connection
    static PreparedStatement stmt

    def setup() {
        stmt = Mock()
        connection = Mock()
    }

    def "Inserir should add a new competencia"() {
        given:
        CompetenciaDAO dao = new CompetenciaDAO(connection)
        Competencia competencia = new Competencia(nomeCompetencia: "Java")

        when:
        dao.inserir(competencia)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "Java")
        1 * stmt.executeUpdate()
    }

    def "Listar should return a list of competencias"() {
        given:
        ResultSet rs = Mock()
        CompetenciaDAO dao = new CompetenciaDAO(connection)

        when:
        List<Competencia> competencias = dao.listar()

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.executeQuery() >> rs
        2 * rs.next() >> true >> false
        1 * rs.getInt("id") >> 1
        1 * rs.getString("nome_competencia") >> "Java"
        competencias.size() == 1
        competencias[0].nomeCompetencia == "Java"
    }

    def "Atualizar should update an existing competencia"() {
        given:
        CompetenciaDAO dao = new CompetenciaDAO(connection)
        Competencia competencia = new Competencia(nomeCompetencia: "Java")

        when:
        dao.atualizar(competencia, 1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "Java")
        1 * stmt.setInt(2, 1)
        1 * stmt.executeUpdate()
    }

    def "Deletar should remove a competencia by id"() {
        given:
        CompetenciaDAO dao = new CompetenciaDAO(connection)

        when:
        dao.deletar(1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.executeUpdate()
    }
}
