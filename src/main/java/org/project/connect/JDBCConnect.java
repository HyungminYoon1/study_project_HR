package org.project.connect;

import java.sql.*;

public class JDBCConnect {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public JDBCConnect() {
        String DB_URL = "jdbc:mysql://192.168.0.12:3306/project_hr";   // container name
        String USER = "HRadmin";
        String PASS = "hrproject2024";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}