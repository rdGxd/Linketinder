package org.example.controller

import org.example.model.Empresa
import org.example.services.EmpresaService

class EmpresasController {

    private EmpresaService service = new EmpresaService()
    String nome, email, estado, cep, descricao
    List<String> comp = new ArrayList<>()
    def scanner = new Scanner(System.in)

    void addUser() {
        println "Digite o nome da empresa: "
        nome = scanner.nextLine()
        println "Digite o email da empresa: "
        email = scanner.nextLine()
        println "Digite o cnpj da empresa: "
        String cnpj = scanner.nextLine()
        println "Digite o pais da empresa: "
        String pais = scanner.nextLine()
        println "Digite o estado da empresa: "
        estado = scanner.nextLine()
        println "Digite o cep da empresa: "
        cep = scanner.nextLine()
        println "Digite a descrição da empresa: "
        descricao = scanner.nextLine()
        println "Digite quantas competencias o candidato tem: "
        int numberCompetencias = scanner.nextInt()
        scanner.nextLine()
        int x = 0
        comp = new ArrayList<>()
        while (x < numberCompetencias) {
            println "Digite qual a ${x+1}: "
            String c = scanner.nextLine()
            comp.add(c)
            x++
        }
        Empresa newEmpresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao, comp)
        service.addUser(newEmpresa)
    }

    HashSet<Empresa> showAll() {
        service.showAll()
    }
}
