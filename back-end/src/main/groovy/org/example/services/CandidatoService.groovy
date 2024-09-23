package org.example.services

import org.example.model.Candidato
import org.example.repository.SqlFactory

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoService {
    HashSet<Candidato> candidatos = [
            new Candidato("João Silva", "joao@example.com", "12345678900", 30, "SP", "01000-000", "Desenvolvedor de software", ["Python", "Java"]),
            new Candidato("Maria Oliveira", "maria@example.com", "23456789012", 28, "RJ", "20000-000", "Analista de dados", ["Java", "Angular"]),
            new Candidato("Pedro Santos", "pedro@example.com", "34567890123", 35, "MG", "30000-000", "Gerente de TI", ["Spring Framework", "Java"]),
            new Candidato("Ana Costa", "ana@example.com", "45678901234", 32, "SP", "01010-000", "Desenvolvedora Frontend", ["Angular", "JavaScript"]),
            new Candidato("Lucas Almeida", "lucas@example.com", "56789012345", 29, "RS", "90000-000", "Arquiteto de Software", ["Python", "Spring Framework"])
    ]

    private SqlFactory sqlFactory = new SqlFactory()

    void listar() {
        String BUSCAR_TODOS = "SELECT * FROM candidatos"

        try{
            Connection conn = sqlFactory.conectar()
            PreparedStatement produtos = conn.prepareStatement(BUSCAR_TODOS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            ResultSet res = produtos.executeQuery()
            res.last()
            int qtd = res.getRow()
            res.beforeFirst()
            if (qtd > 0) {
                println("Listando candidatos")
                println("---------------------------------------------")
                while (res.next()) {
                    println("ID: " + res.getInt(1))
                    println("Nome: " + res.getString(2))
                    println("Email: " + res.getString(3))
                    println("CPF: " + res.getString(4))
                    println("Idade: " + res.getInt(5))
                    println("Estado: " + res.getString(6))
                    println("CEP: " + res.getString(7))
                    println("Descrição: " + res.getString(8))
                    println("---------------------------------------------")
                }
            } else {
                println("Não existem candidatos cadastrados")
            }

        } catch (Exception e) {
            e.printStackTrace()
            println("Erro buscando todos os produtos")
            System.exit(-42)
        }
    }

    void inserir(Candidato user) {
        try {
            Connection conn = sqlFactory.conectar()
            PreparedStatement salvar = conn.prepareStatement("INSERT INTO candidatos (nome, email, cpf, idade, estado, cep, descricao) VALUES (?,?,?,?,?,?,?)")
            salvar.setString(1, user.nome)
            salvar.setString(2, user.email)
            salvar.setString(3, user.cpf)
            salvar.setInt(4, user.idade)
            salvar.setString(5, user.estado)
            salvar.setString(6, user.cep)
            salvar.setString(7, user.descricao)

            salvar.executeUpdate()
            salvar.close()
            sqlFactory.desconectar(conn)
        } catch (Exception e) {
            e.printStackTrace()
            System.exit(-42)
        }
    }

    void atualizar(int id, Candidato newUser) {
        String BUSCAR_POR_ID = "SELECT * FROM candidatos WHERE id = ?"

        try{
            Connection conn = sqlFactory.conectar()
            PreparedStatement candidato = conn.prepareStatement(
                    BUSCAR_POR_ID,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            candidato.setInt(1, id)
            ResultSet res = candidato.executeQuery()

            res.last()
            int qtd = res.getRow()
            res.beforeFirst()
            if (qtd > 0) {
                String ATUALIZAR = "UPDATE candidatos SET nome=?, email=?, cpf=?, idade=?, estado=?, cep=?, descricao=? WHERE id = ?"
                PreparedStatement upd = conn.prepareStatement(ATUALIZAR)
                upd.setString(1, newUser.nome)
                upd.setString(2, newUser.email)
                upd.setString(3, newUser.cpf)
                upd.setInt(4, newUser.idade)
                upd.setString(5, newUser.estado)
                upd.setString(6, newUser.cep)
                upd.setString(7, newUser.descricao)
                upd.setInt(8, id)
                upd.executeUpdate()
                upd.close()
                sqlFactory.desconectar(conn)
            } else {
                print("Não existe candidato com esse ID: ${id}")
            }
        }catch (Exception e) {
            e.printStackTrace()
            println("Erro ao atualizar produto")
            System.exit(-42)
        }
    }

    void deletar(int id) {
        String BUSCAR_POR_ID = "SELECT * FROM candidatos WHERE id = ?"

        try{
            Connection conn = sqlFactory.conectar()
            PreparedStatement candidato = conn.prepareStatement(
                    BUSCAR_POR_ID,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            candidato.setInt(1, id)
            ResultSet res = candidato.executeQuery()

            res.last()
            int qtd = res.getRow()
            res.beforeFirst()
            if (qtd > 0) {
                String DELETAR = "DELETE FROM candidatos WHERE id = ?"
                PreparedStatement del = conn.prepareStatement(DELETAR)
                del.setInt(1, id)
                del.executeUpdate()
                del.close()
                sqlFactory.desconectar(conn)
            } else {
                print("Não existe candidato com esse ID: ${id}")
            }
        }catch (Exception e) {
            e.printStackTrace()
            println("Erro ao deletar produto")
            System.exit(-42)
        }
    }

//    HashSet<Candidato> showAll() {
//        candidatos.each { c -> println(c) }
//    }

}
