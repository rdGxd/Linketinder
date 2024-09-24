package org.example.controller

import org.example.dao.VagaDAO
import org.example.model.Vaga
import org.example.repository.SqlFactory

class VagaController {

    private VagaDAO service = new VagaDAO(SqlFactory.conectar())
    String nomeVaga, descricaoVaga, local, idEmpresa, idVaga
    def scanner = new Scanner(System.in)

    void listar() {
        service.listar()
    }

    void inserir() {
        println("Digite o ID da empresa: ")
        idEmpresa = Integer.parseInt(scanner.nextLine())
        println "Digite o nome da vaga: "
        nomeVaga = scanner.nextLine()
        println "Digite a descrição da vaga: "
        descricaoVaga = scanner.nextLine()
        println "Digite o local da vaga: "
        local = scanner.nextLine()
        Vaga newVaga = new Vaga(idEmpresa, nomeVaga, descricaoVaga, local)
        service.inserir(newVaga)
    }

    void atualizar() {
        println("Informe o código da vaga que deseja atualizar: ")
        idVaga = Integer.parseInt(scanner.nextLine())
        println("Digite o ID da empresa: ")
        idEmpresa = scanner.nextLine()
        println "Digite o nome da vaga: "
        nomeVaga = scanner.nextLine()
        println "Digite a descrição da vaga: "
        descricaoVaga = scanner.nextLine()
        println "Digite o local da vaga: "
        local = scanner.nextLine()
        Vaga newVaga = new Vaga(idEmpresa, nomeVaga, descricaoVaga, local)
        service.atualizar(newVaga, idVaga as int)
    }

    void deletar() {
        println("Informe o código da vaga: ")
        idVaga = Integer.parseInt(scanner.nextLine())
        service.deletar(idVaga as int)
    }
}
