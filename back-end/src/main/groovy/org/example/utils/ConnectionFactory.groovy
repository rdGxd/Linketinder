package org.example.utils

import org.example.Database.Postgres
import org.example.repository.IDBConnectionInterface

import java.sql.Connection

class ConnectionFactory {

    private static IDBConnectionInterface connectionInstance

     static Connection getConnectionInstancePostgres() {
        if (connectionInstance == null) {
            connectionInstance = new Postgres()
        }
        return connectionInstance.conectar()
    }

}
