package org.example.controller

import org.example.dao.CompetenciaDAO
import org.example.model.Competencia
import org.example.repository.SqlFactory

class CompetenciasController {
    private CompetenciaDAO service = new CompetenciaDAO(SqlFactory.conectar())
    String nomeCompetencia
    int idCompetencia
    def scanner = new Scanner(System.in)

    void listar() {
        service.listar()
    }

    void inserir() {
        println "Digite o nome da vaga: "
        nomeCompetencia = scanner.nextLine()
        Competencia newVaga = new Competencia(nomeCompetencia)
        service.inserir(newVaga)
    }

    void atualizar() {
        println("Informe o código da vaga que deseja atualizar: ")
        idCompetencia = Integer.parseInt(scanner.nextLine())
        println "Digite o nome da vaga: "
        nomeCompetencia = scanner.nextLine()
        Competencia newVaga = new Competencia(nomeCompetencia)
        service.atualizar(newVaga, idCompetencia as int)
    }

    void deletar() {
        println("Informe o código da vaga: ")
        idCompetencia = Integer.parseInt(scanner.nextLine())
        service.deletar(idCompetencia as int)
    }
}
