package services

import org.example.model.Empresa

import spock.lang.Specification

class EmpresaServiceTest extends Specification {

    EmpresaService empresaService

    def setup() {
        empresaService = new EmpresaService()
    }

    def "should add a new company"() {
        given: "A new company"
        def newEmpresa = new Empresa("Tech Innovators", "techinnovators@example.com", "12345678", "BR","SP", "01234-567", "ADSAD", ["ASDASD"])

        when: "The company is added"
        empresaService.addUser(newEmpresa)

        then: "The company should be present in the list"
        empresaService.empresas.contains(newEmpresa)
    }
}