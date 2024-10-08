package org.example.view

import org.example.controller.EmpresasController
import org.example.model.Empresa
import org.example.utils.DataInputHandler

class ViewEmpresa {

    static DataInputHandler inputHandler = new DataInputHandler()

    static void listarEmpresas(EmpresasController empresasController) {
        println()
        println "Lista de Empresas:"
        empresasController.listar().forEach {
            println(it)
        }
    }

    static void cadastrarEmpresa(EmpresasController empresasController) {
        empresasController.inserir(criarEmpresa())
    }

    static void atualizarEmpresa(EmpresasController empresasController) {
        println()
        int id = inputHandler.getInput("Informe o código da empresa que deseja atualizar: ").toInteger()
        empresasController.atualizar(criarEmpresa(), id)
    }

    static void deletarEmpresa(EmpresasController empresasController) {
        println()
        int id = inputHandler.getInput("Informe o código do empresa que deseja deletar: ").toInteger()
        empresasController.deletar(id)
    }

    static Empresa criarEmpresa() {
        String nome = inputHandler.getInput("Digite o nome da empresa: ")
        String email = inputHandler.getInput("Digite o email da empresa: ")
        String cnpj = inputHandler.getInput("Digite o cnpj da empresa: ")
        String pais = inputHandler.getInput("Digite o pais da empresa: ")
        String cep = inputHandler.getInput("Digite o cep da empresa: ")
        String descricao = inputHandler.getInput("Digite a descrição da empresa: ")
        String senha = inputHandler.getInput("Digite a senha da empresa: ")
        return new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
    }
}
