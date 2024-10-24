package org.example.model

class Competencia {

    String id, nomeCompetencia

    Competencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia
    }

    Competencia(Map params) {
        this.id = params.id ?: 0
        this.nomeCompetencia = params.nomeCompetencia
    }

    Competencia() {}

    String toString() {
        return "Competencia(id: $id, nomeCompetencia: $nomeCompetencia)"
    }
}
