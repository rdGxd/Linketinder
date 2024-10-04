package org.example.dao

import org.example.model.Empresa
import spock.lang.Specification

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAOTest extends Specification {

    static Connection connection
    static PreparedStatement stmt

    def setup() {
        stmt = Mock()
        connection = Mock()
    }

    def "Inserir should add a new empresa"() {
        given:
        EmpresaDAO dao = new EmpresaDAO(connection)
        Empresa empresa = new Empresa(nomeEmpresa: "Tech Corp", cnpj: "12345678000199", emailCorporativo: "contact@techcorp.com", descricaoEmpresa: "Tech Company", pais: "Brasil", cep: "12345678", senha: "password123")

        when:
        dao.inserir(empresa)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "Tech Corp")
        1 * stmt.setString(2, "12345678000199")
        1 * stmt.setString(3, "contact@techcorp.com")
        1 * stmt.setString(4, "Tech Company")
        1 * stmt.setString(5, "Brasil")
        1 * stmt.setString(6, "12345678")
        1 * stmt.setString(7, "password123")
        1 * stmt.executeUpdate()
    }

    def "Listar should return a list of empresas"() {
        given:
        ResultSet rs = Mock()
        EmpresaDAO dao = new EmpresaDAO(connection)

        when:
        List<Empresa> empresas = dao.listar()

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.executeQuery() >> rs
        2 * rs.next() >> true >> false
        1 * rs.getInt("id") >> 1
        1 * rs.getString("nome_empresa") >> "Tech Corp"
        1 * rs.getString("cnpj") >> "12345678000199"
        1 * rs.getString("email_corporativo") >> "contact@techcorp.com"
        1 * rs.getString("descricao_empresa") >> "Tech Company"
        1 * rs.getString("pais") >> "Brasil"
        1 * rs.getString("cep") >> "12345678"
        1 * rs.getString("senha") >> "password123"
        empresas.size() == 1
        empresas[0].nomeEmpresa == "Tech Corp"
    }

    def "Atualizar should update an existing empresa"() {
        given:
        EmpresaDAO dao = new EmpresaDAO(connection)
        Empresa empresa = new Empresa(nomeEmpresa: "Tech Corp", cnpj: "12345678000199", emailCorporativo: "contact@techcorp.com", descricaoEmpresa: "Tech Company", pais: "Brasil", cep: "12345678", senha: "password123")

        when:
        dao.atualizar(empresa, 1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setString(1, "Tech Corp")
        1 * stmt.setString(2, "12345678000199")
        1 * stmt.setString(3, "contact@techcorp.com")
        1 * stmt.setString(4, "Tech Company")
        1 * stmt.setString(5, "Brasil")
        1 * stmt.setString(6, "12345678")
        1 * stmt.setString(7, "password123")
        1 * stmt.setInt(8, 1)
        1 * stmt.executeUpdate()
    }

    def "Deletar should remove an empresa by id"() {
        given:
        EmpresaDAO dao = new EmpresaDAO(connection)

        when:
        dao.deletar(1)

        then:
        1 * connection.prepareStatement(_) >> stmt
        1 * stmt.setInt(1, 1)
        1 * stmt.executeUpdate()
    }
}
