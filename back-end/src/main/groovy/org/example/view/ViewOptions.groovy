package org.example.view

import org.example.Database.Postgres
import org.example.controller.CandidatosController
import org.example.controller.CompetenciasController
import org.example.controller.EmpresasController
import org.example.controller.VagaController
import org.example.dao.CandidatoDAO
import org.example.dao.CompetenciaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.VagaDAO
import org.example.utils.OptionInputHandler

import java.sql.Connection

class ViewOptions {

    private final Scanner scanner = new Scanner(System.in)
    private final Connection connection = new Postgres().conectar()
    CandidatosController candidatosController = new CandidatosController(new CandidatoDAO(connection))
    EmpresasController empresasController = new EmpresasController(new EmpresaDAO(connection))
    VagaController vagaController = new VagaController(new VagaDAO(connection))
    CompetenciasController competenciasController = new CompetenciasController(new CompetenciaDAO(connection))

    void showCandidatoOptions() {
        println()
        println "1 - Listar Candidatos"
        println "2 - Cadastrar Candidato"
        println "3 - Atualizar Candidato"
        println "4 - Deletar Candidato"
        println "0 - Voltar"

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                ViewCandidato.listarCandidatos(candidatosController)
                println()
                showCandidatoOptions()
                break
            case 2:
                ViewCandidato.cadastrarCandidato(candidatosController)
                println()
                showCandidatoOptions()
                break
            case 3:
                ViewCandidato.atualizarCandidato(candidatosController)
                println()
                showCandidatoOptions()
                break
            case 4:
                ViewCandidato.deletarCandidato(candidatosController)
                println()
                showCandidatoOptions()
                break
            case 0:
                new OptionInputHandler().getOption()
                break
            default:
                println "Opção inválida"
                showCandidatoOptions()
        }

    }

    void showEmpresaOptions() {
        println()
        println "1 - Listar Empresas"
        println "2 - Cadastrar Empresa"
        println "3 - Atualizar Empresa"
        println "4 - Deletar Empresa"
        println "0 - Voltar"

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                ViewEmpresa.listarEmpresas(empresasController)
                println()
                showEmpresaOptions()
                break
            case 2:
                ViewEmpresa.cadastrarEmpresa(empresasController)
                println()
                showEmpresaOptions()
                break
            case 3:
                ViewEmpresa.atualizarEmpresa(empresasController)
                println()
                showEmpresaOptions()
                break
            case 4:
                ViewEmpresa.deletarEmpresa(empresasController)
                println()
                showEmpresaOptions()
                break
            case 0:
                new OptionInputHandler().getOption()
                break
            default:
                println "Opção inválida"
                showEmpresaOptions()
        }
    }

    void showVagaOptions() {
        println()
        println "1 - Listar Vagas"
        println "2 - Cadastrar Vaga"
        println "3 - Atualizar Vaga"
        println "4 - Deletar Vaga"
        println "0 - Voltar"

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                ViewVaga.listarVagas(vagaController)
                println()
                showVagaOptions()
                break
            case 2:
                ViewVaga.cadastrarVaga(vagaController)
                println()
                showVagaOptions()
                break
            case 3:
                ViewVaga.atualizarVaga(vagaController)
                println()
                showVagaOptions()
                break
            case 4:
                ViewVaga.deletarVaga(vagaController)
                println()
                showVagaOptions()
                break
            case 0:
                new OptionInputHandler().getOption()
                break
            default:
                println "Opção inválida"
                showVagaOptions()
        }

    }

    void showCompetenciaOptions() {
        println()
        println "1 - Listar Competências"
        println "2 - Cadastrar Competência"
        println "3 - Atualizar Competência"
        println "4 - Deletar Competência"
        println "0 - Voltar"

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                ViewCompetencia.listarCompetencias(competenciasController)
                println()
                showCompetenciaOptions()
                break
            case 2:
                ViewCompetencia.cadastrarCompetencia(competenciasController)
                println()
                showCompetenciaOptions()
                break
            case 3:
                ViewCompetencia.atualizarCompetencia(competenciasController)
                println()
                showCompetenciaOptions()
                break
            case 4:
                ViewCompetencia.deletarCompetencia(competenciasController)
                println()
                showCompetenciaOptions()
                break
            case 0:
                new OptionInputHandler().getOption()
                break
            default:
                println "Opção inválida"
                showCompetenciaOptions()

        }
    }
}