package org.example.controller

import org.example.model.Candidato
import org.example.services.CandidatoService

class CandidatosController {
    def scanner = new Scanner(System.in)
    private CandidatoService service = new CandidatoService()
    String nome, email, estado, cep, descricao
    List<String> comp = new ArrayList<>()

    void addUser() {
        println "Digite o nome do candidato: "
        nome = scanner.nextLine()
        println "Digite o email do candidato: "
        email = scanner.nextLine()
        println "Digite o cpf do candidato: "
        String cpf = scanner.nextLine()
        println "Digite a idade do candidato: "
        int idade = scanner.nextInt()
        println "Digite o estado do candidato: "
        scanner.nextLine()
        estado = scanner.nextLine()
        println "Digite o cep do candidato: "
        cep = scanner.nextLine()
        println "Digite a descrição do candidato: "
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
        Candidato newUser = new Candidato(nome, email, cpf, idade, estado, cep, descricao, comp)
        service.addUser(newUser)
    }

    HashSet<Candidato> showAll() {
        service.showAll()
    }
}
