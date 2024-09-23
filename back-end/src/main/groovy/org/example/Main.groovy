package org.example

import org.example.controller.CandidatosController
import org.example.controller.EmpresasController

static void main(String[] args) {
    CandidatosController candidatosController = new CandidatosController()
    EmpresasController empresasController = new EmpresasController()
    def sc = new Scanner(System.in)

    while (true) {
        print "Escolha uma opção: "
        println "Menu:"
        println "1. Listar Candidatos"
        println "2. Listar Empresas"
        println "3. Deseja inserir mais candidatos ?"
        println "4. Deseja inserir mais empresas ?"
        println "5. Editar Candidato"
        println "6. Deletar Candidato"
        println "0. Sair"
        def opcao = sc.nextInt()
        switch (opcao) {
            case 1:
                println "Lista de Candidatos:"
                candidatosController.listar()
                break
            case 2:
                println "Lista de Empresas:"
                empresasController.listar()
                break
            case 3:
                candidatosController.inserir()
                break
            case 4:
                empresasController.inserir()
                break
            case 5:
                candidatosController.atualizar()
                break
            case 6:
                candidatosController.deletar()
                break
            case 0:
                println "Saindo..."
                return
            default:
                println "Opção inválida. Tente novamente."
        }
    }
}