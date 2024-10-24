package org.example.view

import org.example.model.Vaga
import org.example.service.VagaService
import org.example.utils.DataInputHandler

class ViewVaga {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarVagas(VagaService vagaService) {
        println "Lista de Vagas:"
        vagaService.listar().forEach {
            println(it)
        }
    }

    static void cadastrarVaga(VagaService vagaService) {
        vagaService.inserir(criarVaga())
    }

    static void atualizarVaga(VagaService vagaService) {
        int id = inputHandler.getInput("Informe o código da vaga que deseja atualizar: ").toInteger()
        vagaService.atualizar(criarVaga(), id)
    }

    static void deletarVaga(VagaService vagaService) {
        int id = inputHandler.getInput("Informe o código da vaga que deseja deletar: ").toInteger()
        vagaService.deletar(id)
    }

    static Vaga criarVaga() {
        String idAttVaga = inputHandler.getInput("Informe o código da empresa: ")
        String nome = inputHandler.getInput("Digite o nome da vaga: ")
        String descricao = inputHandler.getInput("Digite a descrição da vaga: ")
        String local = inputHandler.getInput("Digite o local da vaga: ")
        return new Vaga(idAttVaga, nome, descricao, local)
    }
}
