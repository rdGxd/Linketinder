package org.example.dao

import org.example.mapper.EmpresaMapper
import org.example.model.Empresa
import org.example.repository.ICrud

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO implements ICrud<Empresa> {
    private Connection connection

    EmpresaDAO(Connection connection) {
        this.connection = connection
    }

    @Override
    List<Empresa> listar() {
        String sql = "SELECT * FROM empresas"
        List<Empresa> empresas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery()
            while (rs.next()) {
                empresas.add(new Empresa(
                        id: rs.getInt("id"),
                        nomeEmpresa: rs.getString("nome_empresa"),
                        cnpj: rs.getString("cnpj"),
                        emailCorporativo: rs.getString("email_corporativo"),
                        descricaoEmpresa: rs.getString("descricao_empresa"),
                        pais: rs.getString("pais"),
                        cep: rs.getString("cep"),
                        senha: rs.getString("senha")
                ))
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
            EmpresaMapper.setEntityOnDb(empresa, stmt)
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
            stmt.setInt(8, id)
            EmpresaMapper.setEntityOnDb(empresa, stmt)
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
}