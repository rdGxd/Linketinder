package org.example.view

import org.example.controller.CompetenciasController
import org.example.model.Competencia
import org.example.utils.DataInputHandler

class ViewCompetencia {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarCompetencias(CompetenciasController competenciasController) {
        println()
        println "Lista de Competencias:"
        competenciasController.listar().forEach {
            println(it)
        }
    }

    static void cadastrarCompetencia(CompetenciasController competenciasController) {
        competenciasController.inserir(criarCompetencia())
    }

    static void atualizarCompetencia(CompetenciasController competenciasController) {
        println()
        int id = inputHandler.getInput("Informe o código da competencia que deseja atualizar: ").toInteger()
        competenciasController.atualizar(criarCompetencia(), id)
    }

    static void deletarCompetencia(CompetenciasController competenciasController) {
        println()
        int id = inputHandler.getInput("Informe o código da competencia que deseja deletar: ").toInteger()
        competenciasController.deletar(id)
    }

    static Competencia criarCompetencia() {
        String nome = inputHandler.getInput("Digite o nome da competencia: ")
        return new Competencia(nome)
    }
}
