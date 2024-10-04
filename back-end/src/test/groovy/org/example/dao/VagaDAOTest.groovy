package org.example.dao

import org.example.model.Vaga
import spock.lang.Specification

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAOTest extends Specification {
    
    static Connection connection
    static PreparedStatement stmt

    def setup() {
        stmt = Mock()
        connection = Mock()
    }

    def "Inserir should add a new vaga"() {
        given:
        VagaDAO dao = new VagaDAO(connection)
        Vaga vaga = new Vaga(idEmpresa: 1, nomeVaga: "Developer", descricaoVaga: "Develop software", local: "Remote")

        when:
        dao.inserir(vaga)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.setString(2, "Developer")
        1 * stmt.setString(3, "Develop software")
        1 * stmt.setString(4, "Remote")
        1 * stmt.executeUpdate()
    }

    def "Listar should return a list of vagas"() {
        given:
        ResultSet rs = Mock()
        VagaDAO dao = new VagaDAO(connection)

        when:
        List<Vaga> vagas = dao.listar()

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.executeQuery() >> rs
        2 * rs.next() >> true >> false
        1 * rs.getInt("id") >> 1
        1 * rs.getInt("id_empresa") >> 1
        1 * rs.getString("nome_vaga") >> "Developer"
        1 * rs.getString("descricao_vaga") >> "Develop software"
        1 * rs.getString("local") >> "Remote"
        vagas.size() == 1
        vagas[0].nomeVaga == "Developer"
    }

    def "Atualizar should update an existing vaga"() {
        given:
        VagaDAO dao = new VagaDAO(connection)
        Vaga vaga = new Vaga(idEmpresa: 1, nomeVaga: "Developer", descricaoVaga: "Develop software", local: "Remote")

        when:
        dao.atualizar(vaga, 1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.setString(2, "Developer")
        1 * stmt.setString(3, "Develop software")
        1 * stmt.setString(4, "Remote")
        1 * stmt.setInt(5, 1)
        1 * stmt.executeUpdate()
    }

    def "Deletar should remove a vaga by id"() {
        given:
        VagaDAO dao = new VagaDAO(connection)

        when:
        dao.deletar(1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.executeUpdate()
    }
}
