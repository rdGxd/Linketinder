package org.example.dao

import org.example.model.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO {
    private Connection connection

    EmpresaDAO(Connection connection) {
        this.connection = connection
    }

    void inserir(Empresa empresa) {
        String sql = """
            INSERT INTO empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, pais, cep, senha)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.nomeEmpresa)
            stmt.setString(2, empresa.cnpj)
            stmt.setString(3, empresa.emailCorporativo)
            stmt.setString(4, empresa.descricaoEmpresa)
            stmt.setString(5, empresa.pais)
            stmt.setString(6, empresa.cep)
            stmt.setString(7, empresa.senha)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    void listar() {
        String sql = "SELECT * FROM empresas "
        Empresa empresa = null
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            List<Empresa> empresas = new ArrayList<>()
            while (rs.next()) {
                empresa = new Empresa(
                        id: rs.getInt("id"),
                        nomeEmpresa: rs.getString("nome_empresa"),
                        cnpj: rs.getString("cnpj"),
                        emailCorporativo: rs.getString("email_corporativo"),
                        descricaoEmpresa: rs.getString("descricao_empresa"),
                        pais: rs.getString("pais"),
                        cep: rs.getString("cep"),
                        senha: rs.getString("senha")
                )
                empresas.add(empresa)
            }
            println(empresas)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    void atualizar(Empresa empresa, int id) {
        String sql = """
            UPDATE empresas SET nome_empresa = ?, cnpj = ?, email_corporativo = ?, descricao_empresa = ?, pais = ?, cep = ?, senha = ?
            WHERE id = ?
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.nomeEmpresa)
            stmt.setString(2, empresa.cnpj)
            stmt.setString(3, empresa.emailCorporativo)
            stmt.setString(4, empresa.descricaoEmpresa)
            stmt.setString(5, empresa.pais)
            stmt.setString(6, empresa.cep)
            stmt.setString(7, empresa.senha)
            stmt.setInt(8, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    void deletar(int id) {
        String sql = "DELETE FROM empresas WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }
}
