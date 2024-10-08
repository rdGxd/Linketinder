package org.example.view

import org.example.controller.CandidatosController
import org.example.model.Candidato
import org.example.utils.DataInputHandler

class ViewCandidato {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarCandidatos(CandidatosController candidatosController) {
        println()
        println "Lista de Candidatos:"
        candidatosController.listar().forEach {
            println(it)
        }
    }

    static void cadastrarCandidato(CandidatosController candidatosController) {
        candidatosController.inserir(criarCandidato())
    }

    static void atualizarCandidato(CandidatosController candidatosController) {
        println()
        int id = inputHandler.getInput("Informe o código do candidato que deseja atualizar: ").toInteger()
        candidatosController.atualizar(criarCandidato(), id)
    }

    static void deletarCandidato(CandidatosController candidatosController) {
        println()
        int id = inputHandler.getInput("Informe o código do candidato que deseja deletar: ").toInteger()
        candidatosController.deletar(id)
    }

    static Candidato criarCandidato() {
        String nome = inputHandler.getInput("Digite o nome do candidato: ")
        String sobrenome = inputHandler.getInput("Digite o sobrenome do candidato: ")
        String dataNascimento = inputHandler.getInput("Digite a data de nascimento do candidato: formato (yyyy-MM-dd)")
        String email = inputHandler.getInput("Digite o email do candidato: ")
        String cpf = inputHandler.getInput("Digite o cpf do candidato: ")
        String pais = inputHandler.getInput("Digite o pais do candidato: ")
        String cep = inputHandler.getInput("Digite o cep do candidato: ")
        String descricao = inputHandler.getInput("Digite a descrição do candidato: ")
        String senha = inputHandler.getInput("Digite a senha do candidato: ")
        return new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
    }
}