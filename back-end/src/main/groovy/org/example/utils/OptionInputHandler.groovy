package org.example.utils

import org.example.view.ViewOptions

class OptionInputHandler {
    private final Scanner scanner = new Scanner(System.in)

    void getOption() {
        println()
        println "Escolha uma opção: "
        println "1 - Candidatos"
        println "2 - Empresas"
        println "3 - Vagas"
        println "4 - Competências"
        println "0 - Sair"
        def option = Integer.parseInt(scanner.nextLine())

        switch (option) {
            case 1:
                new ViewOptions().showCandidatoOptions()
                break
            case 2:
                new ViewOptions().showEmpresaOptions()
                break
            case 3:
                new ViewOptions().showVagaOptions()
                break
            case 4:
                new ViewOptions().showCompetenciaOptions()
                break
            case 0:
                break
            default:
                println "Opção inválida"
                getOption()
        }


    }

}