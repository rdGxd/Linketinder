package org.example

import org.example.controller.CandidatosController
import org.example.controller.EmpresasController

static void main(String[] args) {
    CandidatosController candidatosController = new CandidatosController()
    EmpresasController empresasController = new EmpresasController()
    def scanner = new Scanner(System.in)

    while (true) {
        print "Escolha uma opção: "
        println "Menu:"
        println "1. Listar Candidatos"
        println "2. Listar Empresas"
        println "3. Deseja inserir mais candidatos ?"
        println "4. Deseja inserir mais empresas ?"
        println "0. Sair"
        def opcao = scanner.nextInt()
        switch (opcao) {
            case 1:
                println "Lista de Candidatos:"
                candidatosController.showAll()
                break
            case 2:
                println "Lista de Empresas:"
                empresasController.showAll()
                break
            case 3:
                candidatosController.addUser()
                break
            case 4:
                empresasController.addUser()
                break
            case 0:
                println "Saindo..."
                return
            default:
                println "Opção inválida. Tente novamente."
        }
    }
}