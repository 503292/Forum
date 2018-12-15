package ua.model;

import ua.DataBase.InitDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String login;
    private String pass;
    private boolean isAdmin;

    PreparedStatement ps;


    public User(String login, String pass, boolean isAdmin) {
        this.login = login;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public User() {
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



    public int findUserId() throws SQLException {
        PreparedStatement ps = InitDB.conn.prepareStatement("select id_users from users where login like '" + this.getLogin() + "';");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public Map<String, User> getAllUsers() throws SQLException {
        PreparedStatement ps = InitDB.conn.prepareStatement("select  * from users;");
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
        ps = InitDB.conn.prepareStatement("INSERT INTO users (login, pass, isAdmin) VALUES(?, ?, ?)");
        paramToDB();

    }

    public void deleteUser(int id_users) throws SQLException {
        if (this.findUserId() != -1) {
            PreparedStatement ps = InitDB.conn.prepareStatement("delete  from users where id_users ='" + this.findUserId() + "';");
            ResultSet rs = ps.executeQuery();
        }else{
            System.out.println("бля....");
        }
    }

    public void updateUser() throws SQLException {
        if (this.findUserId() != -1) {
            ps = InitDB.conn.prepareStatement("update users set login = ?, pass = ?, isAdmin = ? where id_users =" + this.findUserId() + ";");
            paramToDB();
        }else{
            System.out.println("бля....");
        }
    }

    public void paramToDB() throws SQLException {
        try {
            ps.setString(1, this.getLogin());
            ps.setString(2, this.getPass());
            ps.setBoolean(3, this.isAdmin());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }


}



