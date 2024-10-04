package org.example.repository

import java.sql.Connection

interface IDBConnectionInterface {
    Connection conectar()

    void desconectar(Connection conn)
}