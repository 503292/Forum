package ua.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/forum?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "toor";

    private static volatile InitDB instance;

    static Statement st = null;
    public static Connection conn = null;

    private InitDB() {

    }

    public static InitDB getInstance() throws SQLException {
        InitDB localInitDB = instance;
        if (localInitDB == null) {
            synchronized (InitDB.class) {
                localInitDB = instance;
                if (localInitDB == null) {
                    conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                    st = conn.createStatement();
                    instance = localInitDB = new InitDB();
                }
            }
        }
        return localInitDB;
    }

}
