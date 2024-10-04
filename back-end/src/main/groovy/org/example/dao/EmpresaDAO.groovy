package org.example.dao

import org.example.model.Empresa
import org.example.repository.CRUDMethods

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO implements CRUDMethods<Empresa> {
    private Connection connection

    EmpresaDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Empresa> listar() {
        String sql = "SELECT * FROM empresas"
        Empresa empresa = null
        List<Empresa> empresas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
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
        } catch (SQLException e) {
            e.printStackTrace()
        }
        return empresas
    }

    @Override
    void inserir(Empresa empresa) {
        String sql = """
            INSERT INTO empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, pais, cep, senha)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setEntityOnDb(empresa, stmt)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void atualizar(Empresa empresa, int id) {
        String sql = """
            UPDATE empresas SET nome_empresa = ?, cnpj = ?, email_corporativo = ?, descricao_empresa = ?, pais = ?, cep = ?, senha = ?
            WHERE id = ?
        """
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setEntityOnDb(empresa, stmt)
            stmt.setInt(8, id)
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void deletar(int id) {
        String sql = "DELETE FROM empresas WHERE id = ?"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id)
            stmt.executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }

    @Override
    void setEntityOnDb(Empresa empresa, PreparedStatement stmt) {
        stmt.setString(1, empresa.nomeEmpresa)
        stmt.setString(2, empresa.cnpj)
        stmt.setString(3, empresa.emailCorporativo)
        stmt.setString(4, empresa.descricaoEmpresa)
        stmt.setString(5, empresa.pais)
        stmt.setString(6, empresa.cep)
        stmt.setString(7, empresa.senha)
        stmt.executeUpdate()
    }
}
