package ua.model;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String login;
    private String pass;
    private boolean isAdmin ;
    // private int userId;

    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/forum?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "toor";

    static Statement st = null;
    public static Connection conn = null;

    public User(String login, String pass, boolean isAdmin) {
        this.login = login;
        this.pass = pass;
        this.isAdmin = isAdmin;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

//    public static void main(String[] args) throws SQLException {
//        User us = new User("admin", "admin", true);
//        //us.addNewUser();
//        System.out.println(us.findUserId());
//
//    }


    public Map<String, User> getAllUsers() throws SQLException {
        InitDB();
        PreparedStatement ps = conn.prepareStatement("select  * from users;");
        Map<String, User> users = new HashMap<String, User>();
        try {
            // table of data representing a database result set,
            ResultSet rs = ps.executeQuery();
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {

                    String login = rs.getString(0);
                    String pass = rs.getString(1);
                    Boolean isAdmin = rs.getBoolean(2);
                    User user = new User(login, pass, isAdmin);
                    users.put(login, user);
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
        return users;
    }

    public void addNewUser() throws SQLException {
        InitDB();


        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (login, pass, isAdmin) VALUES(?, ?, ?)");
        try {
            ps.setString(1, getLogin());
            ps.setString(2, getPass());
            ps.setBoolean(3, isAdmin());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }

    }

    public void deleteUser(User user) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("delete  from users where id =" + findUserId() + ";");
        ResultSet rs = ps.executeQuery();
    }

    public void updateUser(User user) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("update users set (login , pass , isAdmin) values (?,?,?)  where id =" + findUserId() + ";");
        try {
            ps.setString(1, getLogin());
            ps.setString(2, getPass());
            ps.setBoolean(3, isAdmin());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }

    }

    public int findUserId() throws SQLException {
        InitDB();
        PreparedStatement ps = conn.prepareStatement("select idusers from users where login like '" + getLogin() + "';");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }


    private void InitDB() {
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}



