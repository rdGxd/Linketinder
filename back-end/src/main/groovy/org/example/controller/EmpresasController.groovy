package org.example.controller

import org.example.dao.EmpresaDAO
import org.example.model.Empresa
import org.example.repository.SqlFactory

class EmpresasController {

    private EmpresaDAO service = new EmpresaDAO(SqlFactory.conectar())
    String nome, cnpj, email, estado, cep, descricao, pais, senha
    def scanner = new Scanner(System.in)

    void listar() {
        service.listar()
    }

    void inserir() {
        println "Digite o nome da empresa: "
        nome = scanner.nextLine()
        println "Digite o email da empresa: "
        email = scanner.nextLine()
        println "Digite o cnpj da empresa: "
        cnpj = scanner.nextLine()
        println "Digite o pais da empresa: "
        pais = scanner.nextLine()
        println "Digite o estado da empresa: "
        estado = scanner.nextLine()
        println "Digite o cep da empresa: "
        cep = scanner.nextLine()
        println "Digite a descrição da empresa: "
        descricao = scanner.nextLine()
        println "Digite a senha da empresa: "
        senha = scanner.nextLine()

        Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
        service.inserir(newEmpresa)
    }

    void atualizar() {
        println("Informe o código do produto: ")
        int id = Integer.parseInt(scanner.nextLine())
        println "Digite o nome da empresa: "
        nome = scanner.nextLine()
        println "Digite o email da empresa: "
        email = scanner.nextLine()
        println "Digite o cnpj da empresa: "
        cnpj = scanner.nextLine()
        println "Digite o pais da empresa: "
        pais = scanner.nextLine()
        println "Digite o estado da empresa: "
        estado = scanner.nextLine()
        println "Digite o cep da empresa: "
        cep = scanner.nextLine()
        println "Digite a descrição da empresa: "
        descricao = scanner.nextLine()
        Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
        service.atualizar(newEmpresa, id)
    }

    void deletar() {
        println("Informe o código do produto: ")
        int id = Integer.parseInt(scanner.nextLine())
        service.deletar(id)
    }
}
