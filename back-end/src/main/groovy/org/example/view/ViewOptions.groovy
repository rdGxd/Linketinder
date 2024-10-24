package org.example.view

import org.example.dao.CandidatoDAO
import org.example.dao.CompetenciaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.VagaDAO
import org.example.service.CandidatoService
import org.example.service.CompetenciaService
import org.example.service.EmpresaService
import org.example.service.VagaService
import org.example.utils.ConnectionFactory
import org.example.utils.OptionInputHandler

import java.sql.Connection

class ViewOptions {

    private final Scanner scanner = new Scanner(System.in)
    private final Connection connection = ConnectionFactory.getConnectionInstancePostgres().conectar()
    CandidatoService candidatoService = new CandidatoService(new CandidatoDAO(connection))
    EmpresaService empresaService = new EmpresaService(new EmpresaDAO(connection))
    VagaService vagaService = new VagaService(new VagaDAO(connection))
    CompetenciaService competenciasService = new CompetenciaService(new CompetenciaDAO(connection))

    void showCandidatoOptions() {
        try {
            println()
            println "1 - Listar Candidatos"
            println "2 - Cadastrar Candidato"
            println "3 - Atualizar Candidato"
            println "4 - Deletar Candidato"
            println "0 - Voltar"

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    ViewCandidato.listarCandidatos(candidatoService)
                    println()
                    showCandidatoOptions()
                    break
                case 2:
                    ViewCandidato.cadastrarCandidato(candidatoService)
                    println()
                    showCandidatoOptions()
                    break
                case 3:
                    ViewCandidato.atualizarCandidato(candidatoService)
                    println()
                    showCandidatoOptions()
                    break
                case 4:
                    ViewCandidato.deletarCandidato(candidatoService)
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
        } finally {
            closeConnection()
        }
    }

    void showEmpresaOptions() {
        try {
            println()
            println "1 - Listar Empresas"
            println "2 - Cadastrar Empresa"
            println "3 - Atualizar Empresa"
            println "4 - Deletar Empresa"
            println "0 - Voltar"

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    ViewEmpresa.listarEmpresas(empresaService)
                    println()
                    showEmpresaOptions()
                    break
                case 2:
                    ViewEmpresa.cadastrarEmpresa(empresaService)
                    println()
                    showEmpresaOptions()
                    break
                case 3:
                    ViewEmpresa.atualizarEmpresa(empresaService)
                    println()
                    showEmpresaOptions()
                    break
                case 4:
                    ViewEmpresa.deletarEmpresa(empresaService)
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
        } finally {
            closeConnection()
        }
    }

    void showVagaOptions() {
        try {
            println()
            println "1 - Listar Vagas"
            println "2 - Cadastrar Vaga"
            println "3 - Atualizar Vaga"
            println "4 - Deletar Vaga"
            println "0 - Voltar"

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    ViewVaga.listarVagas(vagaService)
                    println()
                    showVagaOptions()
                    break
                case 2:
                    ViewVaga.cadastrarVaga(vagaService)
                    println()
                    showVagaOptions()
                    break
                case 3:
                    ViewVaga.atualizarVaga(vagaService)
                    println()
                    showVagaOptions()
                    break
                case 4:
                    ViewVaga.deletarVaga(vagaService)
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
        } finally {
            closeConnection()
        }
    }

    void showCompetenciaOptions() {
        try {
            println()
            println "1 - Listar Competências"
            println "2 - Cadastrar Competência"
            println "3 - Atualizar Competência"
            println "4 - Deletar Competência"
            println "0 - Voltar"

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    ViewCompetencia.listarCompetencias(competenciasService)
                    println()
                    showCompetenciaOptions()
                    break
                case 2:
                    ViewCompetencia.cadastrarCompetencia(competenciasService)
                    println()
                    showCompetenciaOptions()
                    break
                case 3:
                    ViewCompetencia.atualizarCompetencia(competenciasService)
                    println()
                    showCompetenciaOptions()
                    break
                case 4:
                    ViewCompetencia.deletarCompetencia(competenciasService)
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
        } finally {
            closeConnection()
        }
    }

    void closeConnection() {
        ConnectionFactory.getConnectionInstancePostgres().desconectar(connection)
    }

}