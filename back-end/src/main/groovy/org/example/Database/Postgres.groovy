package org.example.Database

import org.example.repository.IDBConnectionInterface

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Postgres implements IDBConnectionInterface {

    @Override
    Connection conectar() throws SQLException, ClassNotFoundException  {
        Class.forName("org.postgresql.Driver")
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", "admin")
        props.setProperty("ssl", "false")
        String url = "jdbc:postgresql://localhost:5432/linketinder"
        return DriverManager.getConnection(url, props)
    }

    @Override
    void desconectar(Connection conn) {
        conn.close()
    }
}
