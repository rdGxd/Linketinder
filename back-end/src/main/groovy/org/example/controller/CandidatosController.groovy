package org.example.controller

import org.example.dao.CandidatoDAO
import org.example.model.Candidato
import org.example.repository.SqlFactory

class CandidatosController {
    def scanner = new Scanner(System.in)
    private CandidatoDAO service = new CandidatoDAO(SqlFactory.conectar())
    String nome, email, pais, cep, descricaoPessoal, sobrenome, cpf, senha, dataNascimento

    void listar() {
        service.listar()
    }

    void inserir() {
        println "Digite o nome do candidato: "
        nome = scanner.nextLine()
        println "Digite o sobrenome do candidato: "
        sobrenome = scanner.nextLine()
        println "Digite a data de nascimento do candidato: formato (yyyy-MM-dd)"
        dataNascimento = scanner.nextLine()
        println "Digite o email do candidato: "
        email = scanner.nextLine()
        println "Digite o cpf do candidato: "
        cpf = scanner.nextLine()
        println "Digite o pais do candidato: "
        pais = scanner.nextLine()
        println "Digite o cep do candidato: "
        cep = scanner.nextLine()
        println "Digite a descrição do candidato: "
        descricaoPessoal = scanner.nextLine()
        println "Digite a senha do candidato: "
        senha = scanner.nextLine()
        Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email,  cpf,  pais,  cep,  descricaoPessoal,  senha)
        service.inserir(newUser)
    }

    void atualizar() {
        println("Informe o código do produto: ")
        int id = Integer.parseInt(scanner.nextLine())
        println "Digite o nome do candidato: "
        nome = scanner.nextLine()
        println "Digite o sobrenome do candidato: "
        sobrenome = scanner.nextLine()
        println "Digite a data de nascimento do candidato: formato (yyyy-MM-dd)"
        dataNascimento = scanner.nextLine()
        println "Digite o email do candidato: "
        email = scanner.nextLine()
        println "Digite o cpf do candidato: "
        cpf = scanner.nextLine()
        println "Digite o pais do candidato: "
        pais = scanner.nextLine()
        println "Digite o cep do candidato: "
        cep = scanner.nextLine()
        println "Digite a descrição do candidato: "
        descricaoPessoal = scanner.nextLine()
        println "Digite a senha do candidato: "
        senha = scanner.nextLine()
        Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email,  cpf,  pais,  cep,  descricaoPessoal,  senha)
        service.atualizar(newUser, id)
    }

    void deletar() {
        println("Informe o código do candidato que deseja deletar: ")
        int id = Integer.parseInt(scanner.nextLine())
        service.deletar(id)
    }
}
