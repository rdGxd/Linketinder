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
import org.example.utils.InputHandler
import org.example.utils.ShowOptions

import java.sql.Connection

static void main(String[] args) {
    InputHandler inputHandler = new InputHandler()

    Connection connection = new Postgres().conectar()

    CandidatoDAO candidatoDAO = new CandidatoDAO(connection)
    EmpresaDAO empresaDAO = new EmpresaDAO(connection)
    VagaDAO vagaDAO = new VagaDAO(connection)
    CompetenciaDAO competenciaDAO = new CompetenciaDAO(connection)

    CandidatosController candidatosController = new CandidatosController(candidatoDAO)
    EmpresasController empresasController = new EmpresasController(empresaDAO)
    VagaController vagasController = new VagaController(vagaDAO)
    CompetenciasController competenciasController = new CompetenciasController(competenciaDAO)

    ShowOptions userInputHandler = new ShowOptions()

    String nome, email, pais, cep, descricao, sobrenome, cpf, senha, dataNascimento, cnpj, local, idAttVaga
    int id

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
            case 3: 1
                nome = inputHandler.getInput("Digite o nome do candidato: ")
                sobrenome = inputHandler.getInput("Digite o sobrenome do candidato: ")
                dataNascimento = inputHandler.getInput("Digite a data de nascimento do candidato: formato (yyyy-MM-dd)")
                email = inputHandler.getInput("Digite o email do candidato: ")
                cpf = inputHandler.getInput("Digite o cpf do candidato: ")
                pais = inputHandler.getInput("Digite o pais do candidato: ")
                cep = inputHandler.getInput("Digite o cep do candidato: ")
                descricao = inputHandler.getInput("Digite a descrição do candidato: ")
                senha = inputHandler.getInput("Digite a senha do candidato: ")
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.inserir(newUser)
                break
            case 4:
                nome = inputHandler.getInput("Digite o nome da empresa: ")
                email = inputHandler.getInput("Digite o email da empresa: ")
                cnpj = inputHandler.getInput("Digite o cnpj da empresa: ")
                pais = inputHandler.getInput("Digite o pais da empresa: ")
                cep = inputHandler.getInput("Digite o cep da empresa: ")
                descricao = inputHandler.getInput("Digite a descrição da empresa: ")
                senha = inputHandler.getInput("Digite a senha da empresa: ")
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.inserir(newEmpresa)
                break
            case 5:
                id = inputHandler.getInput("Informe o código do candidato que deseja atualizar: ").toInteger()
                nome = inputHandler.getInput("Digite o nome do candidato: ")
                sobrenome = inputHandler.getInput("Digite o sobrenome do candidato: ")
                dataNascimento = inputHandler.getInput("Digite a data de nascimento do candidato: formato (yyyy-MM-dd)")
                email = inputHandler.getInput("Digite o email do candidato: ")
                cpf = inputHandler.getInput("Digite o cpf do candidato: ")
                pais = inputHandler.getInput("Digite o pais do candidato: ")
                cep = inputHandler.getInput("Digite o cep do candidato: ")
                descricao = inputHandler.getInput("Digite a descrição do candidato: ")
                senha = inputHandler.getInput("Digite a senha do candidato: ")
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.atualizar(newUser, id)
                break
            case 6:
                id = inputHandler.getInput("Informe o código do candidato que deseja deletar: ").toInteger()
                candidatosController.deletar(id)
                break
            case 7:
                id = inputHandler.getInput("Informe o código da empresa que deseja atualizar: ").toInteger()
                nome = inputHandler.getInput("Digite o nome da empresa: ")
                email = inputHandler.getInput("Digite o email da empresa: ")
                cnpj = inputHandler.getInput("Digite o cnpj da empresa: ")
                pais = inputHandler.getInput("Digite o pais da empresa: ")
                cep = inputHandler.getInput("Digite o cep da empresa: ")
                descricao = inputHandler.getInput("Digite a descrição da empresa: ")
                senha = inputHandler.getInput("Digite a senha da empresa: ")
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.atualizar(newEmpresa, id)
                break
            case 8:
                id = inputHandler.getInput("Informe o código da empresa que deseja deletar: ").toInteger()
                empresasController.deletar(id)
                break
            case 9:
                vagasController.listar().forEach {
                    println(it)
                }
                break
            case 10:
                idAttVaga = inputHandler.getInput("Informe o código da empresa: ")
                nome = inputHandler.getInput("Digite o nome da vaga: ")
                descricao = inputHandler.getInput("Digite a descrição da vaga: ")
                local = inputHandler.getInput("Digite o local da vaga: ")
                Vaga newVaga = new Vaga(idAttVaga, nome, descricao, local)
                vagasController.inserir(newVaga)
                break
            case 11:
                id = inputHandler.getInput("Informe o código da vaga que deseja atualizar: ").toInteger()
                idAttVaga = inputHandler.getInput("Informe o código da empresa: ")
                nome = inputHandler.getInput("Digite o nome da vaga: ")
                descricao = inputHandler.getInput("Digite a descrição da vaga: ")
                local = inputHandler.getInput("Digite o local da vaga: ")
                Vaga newVaga = new Vaga(id.toString(), nome, descricao, local)
                vagasController.atualizar(newVaga, idAttVaga.toInteger())
                break
            case 12:
                id = inputHandler.getInput("Informe o código da vaga que deseja deletar: ").toInteger()
                vagasController.deletar(id)
                break
            case 13:
                competenciasController.listar().forEach {
                    println(it)
                }
                break
            case 14:
                nome = inputHandler.getInput("Digite o nome da competencia: ")
                Competencia newVaga = new Competencia(nome)
                competenciasController.inserir(newVaga)
                break
            case 15:
                id = inputHandler.getInput("Informe o código da competencia que deseja atualizar: ").toInteger()
                nome = inputHandler.getInput("Digite o nome da competencia: ")
                Competencia newVaga = new Competencia(nome)
                competenciasController.atualizar(newVaga, id)
                break
            case 16:
                id = inputHandler.getInput("Informe o código da competencia que deseja deletar: ").toInteger()
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