import org.example.Database.Postgres
import org.example.controller.CandidatosController
import org.example.controller.CompetenciasController
import org.example.controller.EmpresasController
import org.example.controller.VagaController
import org.example.dao.CandidatoDAO
import org.example.dao.CompetenciaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.VagaDAO
import org.example.model.Candidato
import org.example.model.Competencia
import org.example.model.Empresa
import org.example.model.Vaga
import org.example.utils.UserInputHandler

import java.sql.Connection

static void main(String[] args) {
    Connection connection = new Postgres().conectar()

    CandidatoDAO candidatoDAO = new CandidatoDAO(connection)
    EmpresaDAO empresaDAO = new EmpresaDAO(connection)
    VagaDAO vagaDAO = new VagaDAO(connection)
    CompetenciaDAO competenciaDAO = new CompetenciaDAO(connection)

    CandidatosController candidatosController = new CandidatosController(candidatoDAO)
    EmpresasController empresasController = new EmpresasController(empresaDAO)
    VagaController vagasController = new VagaController(vagaDAO)
    CompetenciasController competenciasController = new CompetenciasController(competenciaDAO)

    UserInputHandler userInputHandler = new UserInputHandler()

    String nome, email, pais, cep, descricao, sobrenome, cpf, senha, dataNascimento, cnpj, local, idAttVaga
    int id

    def scanner = new Scanner(System.in)

    while (true) {
        int opcao = userInputHandler.getOption()
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