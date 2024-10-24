package org.example.view

import org.example.model.Competencia
import org.example.service.CompetenciaService
import org.example.utils.DataInputHandler

class ViewCompetencia {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarCompetencias(CompetenciaService competenciaService) {
        println()
        println "Lista de Competencias:"
        competenciaService.listar().forEach {
            println(it)
        }
    }

    static void cadastrarCompetencia(CompetenciaService competenciaService) {
        competenciaService.inserir(criarCompetencia())
    }

    static void atualizarCompetencia(CompetenciaService competenciaService) {
        println()
        int id = inputHandler.getInput("Informe o código da competencia que deseja atualizar: ").toInteger()
        competenciaService.atualizar(criarCompetencia(), id)
    }

    static void deletarCompetencia(CompetenciaService competenciaService) {
        println()
        int id = inputHandler.getInput("Informe o código da competencia que deseja deletar: ").toInteger()
        competenciaService.deletar(id)
    }

    static Competencia criarCompetencia() {
        String nome = inputHandler.getInput("Digite o nome da competencia: ")
        return new Competencia(nome)
    }
}
