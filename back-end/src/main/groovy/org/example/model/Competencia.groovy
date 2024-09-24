package org.example.model

class Competencia {
    String id
    String nomeCompetencia

    Competencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia
    }

    Competencia(Map params) {
        this.id = params.id ?: 0
        this.nomeCompetencia = params.nomeCompetencia
    }

    String toString() {
        return "Competencia(id: $id, nomeCompetencia: $nomeCompetencia)"
    }
}
