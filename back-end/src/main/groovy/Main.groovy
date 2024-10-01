import org.example.controller.CandidatosController
import org.example.controller.CompetenciasController
import org.example.controller.EmpresasController
import org.example.controller.VagaController
import org.example.model.Candidato
import org.example.model.Competencia
import org.example.model.Empresa
import org.example.model.Vaga

static void main(String[] args) {
    CandidatosController candidatosController = new CandidatosController()
    EmpresasController empresasController = new EmpresasController()
    VagaController vagasController = new VagaController()
    CompetenciasController competenciasController = new CompetenciasController()
    String nome, email, pais, cep, descricao, sobrenome, cpf, senha, dataNascimento, cnpj, local, idAttVaga
    int id
    def scanner = new Scanner(System.in)

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
        int opcao = Integer.parseInt(scanner.nextLine())
        switch (opcao) {
            case 1:
                println "Lista de Candidatos:"
                candidatosController.listar().forEach {
                    println(it)
                }
                break
            case 2:
                println "Lista de Empresas:"
                empresasController.listar().forEach {
                    println(it)
                }
                break
            case 3:
                println "Digite o nome do candidato: "
                nome = scanner.nextLine()
                println "Digite o sobrenome do candidato: "
                sobrenome = scanner.nextLine()
                println "Digite a data de nascimento do candidato: formato (yyyy-MM-dd)"
                dataNascimento = scanner.nextLine()
                println "Digite o email do candidato: "
                email = scanner.nextLine()
                println "Digite o cpf do candidato: "
                cpf = scanner.nextLine()
                println "Digite o pais do candidato: "
                pais = scanner.nextLine()
                println "Digite o cep do candidato: "
                cep = scanner.nextLine()
                println "Digite a descrição do candidato: "
                descricao = scanner.nextLine()
                println "Digite a senha do candidato: "
                senha = scanner.nextLine()
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.inserir(newUser)
                break
            case 4:
                println "Digite o nome da empresa: "
                nome = scanner.nextLine()
                println "Digite o email da empresa: "
                email = scanner.nextLine()
                println "Digite o cnpj da empresa: "
                cnpj = scanner.nextLine()
                println "Digite o pais da empresa: "
                pais = scanner.nextLine()
                println "Digite o cep da empresa: "
                cep = scanner.nextLine()
                println "Digite a descrição da empresa: "
                descricao = scanner.nextLine()
                println "Digite a senha da empresa: "
                senha = scanner.nextLine()
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.inserir(newEmpresa)
                break
            case 5:
                println("Informe o código do produto: ")
                id = Integer.parseInt(scanner.nextLine())
                println "Digite o nome do candidato: "
                nome = scanner.nextLine()
                println "Digite o sobrenome do candidato: "
                sobrenome = scanner.nextLine()
                println "Digite a data de nascimento do candidato: formato (yyyy-MM-dd)"
                dataNascimento = scanner.nextLine()
                println "Digite o email do candidato: "
                email = scanner.nextLine()
                println "Digite o cpf do candidato: "
                cpf = scanner.nextLine()
                println "Digite o pais do candidato: "
                pais = scanner.nextLine()
                println "Digite o cep do candidato: "
                cep = scanner.nextLine()
                println "Digite a descrição do candidato: "
                descricao = scanner.nextLine()
                println "Digite a senha do candidato: "
                senha = scanner.nextLine()
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.atualizar(newUser, id)
                break
            case 6:
                println("Informe o código do candidato que deseja deletar: ")
                id = Integer.parseInt(scanner.nextLine())
                candidatosController.deletar(id)
                break
            case 7:
                println("Informe o código da empresa que deseja atualizar: ")
                id = Integer.parseInt(scanner.nextLine())
                println "Digite o nome da empresa: "
                nome = scanner.nextLine()
                println "Digite o email da empresa: "
                email = scanner.nextLine()
                println "Digite o cnpj da empresa: "
                cnpj = scanner.nextLine()
                println "Digite o pais da empresa: "
                pais = scanner.nextLine()
                println "Digite o cep da empresa: "
                cep = scanner.nextLine()
                println "Digite a descrição da empresa: "
                descricao = scanner.nextLine()
                println "Digite a senha da empresa: "
                senha = scanner.nextLine()
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.atualizar(newEmpresa, id)
                break
            case 8:
                println("Informe o código do produto: ")
                id = Integer.parseInt(scanner.nextLine())
                empresasController.deletar(id)
                break
            case 9:
                vagasController.listar().forEach {
                    println(it)
                }
                break
            case 10:
                println("Digite o ID da empresa: ")
                id = Integer.parseInt(scanner.nextLine())
                println "Digite o nome da vaga: "
                nome = scanner.nextLine()
                println "Digite a descrição da vaga: "
                descricao = scanner.nextLine()
                println "Digite o local da vaga: "
                local = scanner.nextLine()
                Vaga newVaga = new Vaga(id.toString(), nome, descricao, local)
                vagasController.inserir(newVaga)
                break
            case 11:
                println("Informe o código da vaga que deseja atualizar: ")
                id = Integer.parseInt(scanner.nextLine())
                println("Digite o ID da empresa: ")
                idAttVaga = scanner.nextLine()
                println "Digite o nome da vaga: "
                nome = scanner.nextLine()
                println "Digite a descrição da vaga: "
                descricao = scanner.nextLine()
                println "Digite o local da vaga: "
                local = scanner.nextLine()
                Vaga newVaga = new Vaga(id.toString(), nome, descricao, local)
                vagasController.atualizar(newVaga, idAttVaga.toInteger())
                break
            case 12:
                println("Informe o código da vaga: ")
                id = Integer.parseInt(scanner.nextLine())
                vagasController.deletar(id)
                break
            case 13:
                competenciasController.listar().forEach {
                    println(it)
                }
                break
            case 14:
                println "Digite o nome da vaga: "
                nome = scanner.nextLine()
                Competencia newVaga = new Competencia(nome)
                competenciasController.inserir(newVaga)
                break
            case 15:
                println("Informe o código da vaga que deseja atualizar: ")
                id = Integer.parseInt(scanner.nextLine())
                println "Digite o nome da vaga: "
                nome = scanner.nextLine()
                Competencia newVaga = new Competencia(nome)
                competenciasController.atualizar(newVaga, id)
                break
            case 16:
                println("Informe o código da vaga: ")
                id = Integer.parseInt(scanner.nextLine())
                competenciasController.deletar(id)
                break
            case 0:
                println "Saindo..."
                return
            default:
                println "Opção inválida. Tente novamente."
        }
    }
}