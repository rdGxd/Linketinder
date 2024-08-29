package org.example.services

import org.example.model.Candidato

class CandidatoService {
    HashSet<Candidato> candidatos = [
            new Candidato("João Silva", "joao@example.com", "12345678900", 30, "SP", "01000-000", "Desenvolvedor de software", ["Python", "Java"]),
            new Candidato("Maria Oliveira", "maria@example.com", "23456789012", 28, "RJ", "20000-000", "Analista de dados", ["Java", "Angular"]),
            new Candidato("Pedro Santos", "pedro@example.com", "34567890123", 35, "MG", "30000-000", "Gerente de TI", ["Spring Framework", "Java"]),
            new Candidato("Ana Costa", "ana@example.com", "45678901234", 32, "SP", "01010-000", "Desenvolvedora Frontend", ["Angular", "JavaScript"]),
            new Candidato("Lucas Almeida", "lucas@example.com", "56789012345", 29, "RS", "90000-000", "Arquiteto de Software", ["Python", "Spring Framework"])
    ]

    void addUser(Candidato user) {
        candidatos.add(user)
    }

    HashSet<Candidato> showAll() {
        candidatos.each { c -> println(c) }
    }

}
