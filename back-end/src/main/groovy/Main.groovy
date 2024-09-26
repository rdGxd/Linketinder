import org.example.controller.CandidatosController
import org.example.controller.CompetenciasController
import org.example.controller.EmpresasController
import org.example.controller.VagaController

static void main(String[] args) {
    CandidatosController candidatosController = new CandidatosController()
    EmpresasController empresasController = new EmpresasController()
    VagaController vagasController = new VagaController()
    CompetenciasController competenciasController = new CompetenciasController()
    def sc = new Scanner(System.in)

    while (true) {
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
        int opcao = sc.nextInt()
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
            case 7:
                empresasController.atualizar()
                break
            case 8:
                empresasController.deletar()
                break
            case 9:
                vagasController.listar()
                break
            case 10:
                vagasController.inserir()
                break
            case 11:
                vagasController.atualizar()
                break
            case 12:
                vagasController.deletar()
                break
            case 13:
                competenciasController.listar()
                break
            case 14:
                competenciasController.inserir()
                break
            case 15:
                competenciasController.atualizar()
                break
            case 16:
                competenciasController.deletar()
                break
            case 0:
                println "Saindo..."
                return
            default:
                println "Opção inválida. Tente novamente."
        }
    }
}