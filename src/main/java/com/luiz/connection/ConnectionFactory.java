package com.luiz.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            //Configura��o para acessar o postgres
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres",
                    //ToDo preencha a senha do banco aqui
                    "any32manu");
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return conn;
    }

}