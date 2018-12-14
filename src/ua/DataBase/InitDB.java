package ua.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class InitDB {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/forum?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "toor";

    private static final InitDB INSTANCE = new InitDB();

    static Statement st = null;
    public static Connection conn = null;

    private InitDB(){
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static InitDB getInstance() throws SQLException {
        return INSTANCE;
    }


}
