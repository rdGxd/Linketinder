package services

import org.example.model.Candidato

import spock.lang.Specification

class CandidatoServiceTest extends Specification {

    CandidatoService candidatoService

    def setup() {
        candidatoService = new CandidatoService()
    }

    def "should add a new candidate"() {
        given: "A new candidate"
        def newCandidato = new Candidato("Carlos Pereira", "carlos@example.com", "67890123456", 27, "BA", "40000-000", "Engenheiro de Software", ["Go", "Kotlin"])

        when: "The candidate is added"
        candidatoService.addUser(newCandidato)

        then: "The candidate should be present in the list"
        candidatoService.candidatos.contains(newCandidato)
    }
}

