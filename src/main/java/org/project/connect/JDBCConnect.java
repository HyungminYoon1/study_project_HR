package org.project.connect;

import java.sql.*;

public class JDBCConnect {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public JDBCConnect() {
        String DB_URL = "jdbc:mysql://localhost:3305/TEST";   // container name
        String USER = "test";
        String PASS = "1234";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}