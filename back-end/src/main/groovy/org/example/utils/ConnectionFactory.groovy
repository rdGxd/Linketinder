package org.example.utils

import org.example.Database.Postgres
import org.example.repository.IDBConnectionInterface

class ConnectionFactory {

    private static IDBConnectionInterface connectionInstance

    static IDBConnectionInterface getConnectionInstance() {
        if (connectionInstance == null) {
            connectionInstance = new Postgres()
        }
        return connectionInstance
    }
}
