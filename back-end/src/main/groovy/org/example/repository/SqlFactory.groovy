package org.example.repository

import org.example.model.Candidato

import java.sql.Connection
import java.sql.DriverManager

class SqlFactory {

    static Connection conectar() {
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", "admin")
        props.setProperty("ssl", "false")
        String URL_SERIVODR = "jdbc:postgresql://localhost:5432/linketinder"

        try {
            return DriverManager.getConnection(URL_SERIVODR, props)
        } catch (Exception e) {
            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                println("Verifique o driver de conexão")
            } else {
                println("Verifique se o servidor está ativo")
            }
            System.exit(-42)
            return null
        }
    }

    static void desconectar(Connection conn) {
        try {
            conn.close()
        } catch (Exception e) {
            e.printStackTrace()
            println("Erro ao desconectar")
            System.exit(-42)
        }
    }
}