package org.example.view

import org.example.controller.VagaController
import org.example.model.Vaga
import org.example.utils.DataInputHandler

class ViewVaga {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarVagas(VagaController vagaController) {
        println "Lista de Vagas:"
        vagaController.listar().forEach {
            println(it)
        }
    }

    static void cadastrarVaga(VagaController vagaController) {
        vagaController.inserir(criarVaga())
    }

    static void atualizarVaga(VagaController vagaController) {
        int id = inputHandler.getInput("Informe o código da vaga que deseja atualizar: ").toInteger()
        vagaController.atualizar(criarVaga(), id)
    }

    static void deletarVaga(VagaController vagaController) {
        int id = inputHandler.getInput("Informe o código da vaga que deseja deletar: ").toInteger()
        vagaController.deletar(id)
    }

    static Vaga criarVaga() {
        String idAttVaga = inputHandler.getInput("Informe o código da empresa: ")
        String nome = inputHandler.getInput("Digite o nome da vaga: ")
        String descricao = inputHandler.getInput("Digite a descrição da vaga: ")
        String local = inputHandler.getInput("Digite o local da vaga: ")
        return new Vaga(idAttVaga, nome, descricao, local)
    }
}
