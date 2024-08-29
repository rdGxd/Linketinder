package org.example.services

import org.example.model.Empresa


class EmpresaService {
    HashSet<Empresa> empresas = [
            new Empresa("Arroz-Gostoso", "contato@arroz-gostoso.com.br", "12.345.678/0001-95", "Brasil", "SP", "01100-000", "Empresa de alimentos", ["Python", "Java"]),
            new Empresa("Império do Boliche", "contato@imperiodoboliche.com.br", "23.456.789/0001-96", "Brasil", "RJ", "22000-000", "Boliche e entretenimento", ["Java", "Angular"]),
            new Empresa("TechSolutions", "contato@techsolutions.com.br", "34.567.890/0001-97", "Brasil", "MG", "30100-000", "Consultoria em TI", ["Spring Framework", "Python"]),
            new Empresa("EducaTech", "contato@educatech.com.br", "45.678.901/0001-98", "Brasil", "SP", "02000-000", "Tecnologia educacional", ["JavaScript", "Angular"]),
            new Empresa("MediHealth", "contato@medihealth.com.br", "56.789.012/0001-99", "Brasil", "RS", "90500-000", "Saúde e tecnologia", ["Python", "Spring Framework"])
    ]

    void addUser(Empresa user) {
        empresas.add(user)
    }

    HashSet<Empresa> showAll() {
        empresas.each {c -> println(c)}
    }
}
