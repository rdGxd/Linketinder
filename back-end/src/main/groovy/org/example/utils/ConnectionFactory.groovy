package org.example.utils

import org.example.Database.Postgres
import org.example.repository.IDBConnectionInterface

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionFactory {

    private static IDBConnectionInterface connectionInstance

     static IDBConnectionInterface getConnectionInstancePostgres() {
        if (connectionInstance == null) {
            connectionInstance = new Postgres()
        }
        return connectionInstance
    }

    static Connection getConnectionInstancePostgresHttp() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver")
        String url = "jdbc:postgresql://localhost:5432/linketinder"
        String user = "postgres"
        String password = "admin"
        return DriverManager.getConnection(url, user, password)
    }
}
