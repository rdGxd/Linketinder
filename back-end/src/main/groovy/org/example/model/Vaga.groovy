package org.example.model

class Vaga {
    String id
    String idEmpresa
    String nomeVaga
    String descricaoVaga
    String local

    // Construtor
    Vaga( String idEmpresa, String nomeVaga, String descricaoVaga, String local) {
        this.idEmpresa = idEmpresa
        this.nomeVaga = nomeVaga
        this.descricaoVaga = descricaoVaga
        this.local = local
    }

    Vaga(Map params) {
        this.id = params.id ?: 0
        this.idEmpresa = params.idEmpresa
        this.nomeVaga = params.nomeVaga
        this.descricaoVaga = params.descricaoVaga
        this.local = params.local
    }

    // Método toString para exibir a vaga
    String toString() {
        return "Vaga(id: $id, idEmpresa: $idEmpresa, nomeVaga: $nomeVaga, descricaoVaga: $descricaoVaga, local: $local)"
    }
}
