package org.example.model

class Empresa {

    String nomeEmpresa, cnpj, emailCorporativo, descricaoEmpresa, pais, cep, senha, id

    Empresa(String nomeEmpresa, String cnpj, String emailCorporativo, String descricaoEmpresa, String pais, String cep, String senha) {
        this.nomeEmpresa = nomeEmpresa
        this.cnpj = cnpj
        this.emailCorporativo = emailCorporativo
        this.descricaoEmpresa = descricaoEmpresa
        this.pais = pais
        this.cep = cep
        this.senha = senha
    }

    Empresa(Map params) {
        this.id = params.id ?: 0
        this.nomeEmpresa = params.nomeEmpresa
        this.cnpj = params.cnpj
        this.emailCorporativo = params.emailCorporativo
        this.descricaoEmpresa = params.descricaoEmpresa
        this.pais = params.pais
        this.cep = params.cep
        this.senha = params.senha
    }

    Empresa() {}

    String toString() {
        return "Empresa( id: $id, nomeEmpresa: $nomeEmpresa, cnpj: $cnpj, emailCorporativo: $emailCorporativo, descricaoEmpresa: $descricaoEmpresa, pais: $pais, cep: $cep, senha: $senha)"
    }
}
