package org.example.utils

class OptionInputHandler {
    private final Scanner scanner = new Scanner(System.in)

    int getOption() {
        println "Escolha uma opção: "
        println "1. Listar Candidatos"
        println "2. Listar Empresas"
        println "3. Deseja inserir mais candidatos ?"
        println "4. Deseja inserir mais empresas ?"
        println "5. Editar Candidato"
        println "6. Deletar Candidato"
        println "7. Editar Empresa"
        println "8. Deletar Empresa"
        println "9. Listar Vagas"
        println "10. Deseja inserir mais vagas ?"
        println "11. Deseja atualizar uma vaga ?"
        println "12. Deseja deletar uma vaga ?"
        println "13. Listar Competências"
        println "14. Deseja inserir mais competências ?"
        println "15. Deseja atualizar uma competência ?"
        println "16. Deseja deletar uma competência ?"
        println "0. Sair"
        return Integer.parseInt(scanner.nextLine())
    }

}