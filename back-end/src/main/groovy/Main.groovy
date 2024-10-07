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
import org.example.utils.DataInputHandler
import org.example.utils.OptionInputHandler

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

    OptionInputHandler optionInputHandler = new OptionInputHandler()
    DataInputHandler dataInputHandler = new DataInputHandler()


    String nome, email, pais, cep, descricao, sobrenome, cpf, senha, dataNascimento, cnpj, local, idAttVaga
    int id

    while (true) {
        int opcao = optionInputHandler.getOption()
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
                nome = dataInputHandler.getInput("Digite o nome do candidato: ")
                sobrenome = dataInputHandler.getInput("Digite o sobrenome do candidato: ")
                dataNascimento = dataInputHandler.getInput("Digite a data de nascimento do candidato: formato (yyyy-MM-dd)")
                email = dataInputHandler.getInput("Digite o email do candidato: ")
                cpf = dataInputHandler.getInput("Digite o cpf do candidato: ")
                pais = dataInputHandler.getInput("Digite o pais do candidato: ")
                cep = dataInputHandler.getInput("Digite o cep do candidato: ")
                descricao = dataInputHandler.getInput("Digite a descrição do candidato: ")
                senha = dataInputHandler.getInput("Digite a senha do candidato: ")
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.inserir(newUser)
                break
            case 4:
                nome = dataInputHandler.getInput("Digite o nome da empresa: ")
                email = dataInputHandler.getInput("Digite o email da empresa: ")
                cnpj = dataInputHandler.getInput("Digite o cnpj da empresa: ")
                pais = dataInputHandler.getInput("Digite o pais da empresa: ")
                cep = dataInputHandler.getInput("Digite o cep da empresa: ")
                descricao = dataInputHandler.getInput("Digite a descrição da empresa: ")
                senha = dataInputHandler.getInput("Digite a senha da empresa: ")
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.inserir(newEmpresa)
                break
            case 5:
                id = dataInputHandler.getInput("Informe o código do candidato que deseja atualizar: ").toInteger()
                nome = dataInputHandler.getInput("Digite o nome do candidato: ")
                sobrenome = dataInputHandler.getInput("Digite o sobrenome do candidato: ")
                dataNascimento = dataInputHandler.getInput("Digite a data de nascimento do candidato: formato (yyyy-MM-dd)")
                email = dataInputHandler.getInput("Digite o email do candidato: ")
                cpf = dataInputHandler.getInput("Digite o cpf do candidato: ")
                pais = dataInputHandler.getInput("Digite o pais do candidato: ")
                cep = dataInputHandler.getInput("Digite o cep do candidato: ")
                descricao = dataInputHandler.getInput("Digite a descrição do candidato: ")
                senha = dataInputHandler.getInput("Digite a senha do candidato: ")
                Candidato newUser = new Candidato(nome, sobrenome, dataNascimento, email, cpf, pais, cep, descricao, senha)
                candidatosController.atualizar(newUser, id)
                break
            case 6:
                id = dataInputHandler.getInput("Informe o código do candidato que deseja deletar: ").toInteger()
                candidatosController.deletar(id)
                break
            case 7:
                id = dataInputHandler.getInput("Informe o código da empresa que deseja atualizar: ").toInteger()
                nome = dataInputHandler.getInput("Digite o nome da empresa: ")
                email = dataInputHandler.getInput("Digite o email da empresa: ")
                cnpj = dataInputHandler.getInput("Digite o cnpj da empresa: ")
                pais = dataInputHandler.getInput("Digite o pais da empresa: ")
                cep = dataInputHandler.getInput("Digite o cep da empresa: ")
                descricao = dataInputHandler.getInput("Digite a descrição da empresa: ")
                senha = dataInputHandler.getInput("Digite a senha da empresa: ")
                Empresa newEmpresa = new Empresa(nome, cnpj, email, descricao, pais, cep, senha)
                empresasController.atualizar(newEmpresa, id)
                break
            case 8:
                id = dataInputHandler.getInput("Informe o código da empresa que deseja deletar: ").toInteger()
                empresasController.deletar(id)
                break
            case 9:
                vagasController.listar().forEach {
                    println(it)
                }
                break
            case 10:
                idAttVaga = dataInputHandler.getInput("Informe o código da empresa: ")
                nome = dataInputHandler.getInput("Digite o nome da vaga: ")
                descricao = dataInputHandler.getInput("Digite a descrição da vaga: ")
                local = dataInputHandler.getInput("Digite o local da vaga: ")
                Vaga newVaga = new Vaga(idAttVaga, nome, descricao, local)
                vagasController.inserir(newVaga)
                break
            case 11:
                id = dataInputHandler.getInput("Informe o código da vaga que deseja atualizar: ").toInteger()
                idAttVaga = dataInputHandler.getInput("Informe o código da empresa: ")
                nome = dataInputHandler.getInput("Digite o nome da vaga: ")
                descricao = dataInputHandler.getInput("Digite a descrição da vaga: ")
                local = dataInputHandler.getInput("Digite o local da vaga: ")
                Vaga newVaga = new Vaga(id.toString(), nome, descricao, local)
                vagasController.atualizar(newVaga, idAttVaga.toInteger())
                break
            case 12:
                id = dataInputHandler.getInput("Informe o código da vaga que deseja deletar: ").toInteger()
                vagasController.deletar(id)
                break
            case 13:
                competenciasController.listar().forEach {
                    println(it)
                }
                break
            case 14:
                nome = dataInputHandler.getInput("Digite o nome da competencia: ")
                Competencia newVaga = new Competencia(nome)
                competenciasController.inserir(newVaga)
                break
            case 15:
                id = dataInputHandler.getInput("Informe o código da competencia que deseja atualizar: ").toInteger()
                nome = dataInputHandler.getInput("Digite o nome da competencia: ")
                Competencia newVaga = new Competencia(nome)
                competenciasController.atualizar(newVaga, id)
                break
            case 16:
                id = dataInputHandler.getInput("Informe o código da competencia que deseja deletar: ").toInteger()
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