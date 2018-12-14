package ua.DataBase;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ua.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


//public interface UserDataBase  {
//    public static Map<String, User> getAllUsers(Connection conn) throws SQLException {
//
//        PreparedStatement ps = conn.prepareStatement("select  * from users;");
//        Map<String, User> users = new HashMap<String, User>();
//        try {
//            // table of data representing a database result set,
//            ResultSet rs = ps.executeQuery();
//            try {
//                // can be used to get information about the types and properties of the columns in a ResultSet object
//                ResultSetMetaData md = rs.getMetaData();
//
//                for (int i = 1; i <= md.getColumnCount(); i++)
//                    System.out.print(md.getColumnName(i) + "\t\t");
//                System.out.println();
//
//                while (rs.next()) {
//
//                    String login = rs.getString(0);
//                    String pass = rs.getString(1);
//                    Boolean isAdmin = rs.getBoolean(2);
//                    User user = new User(login, pass, isAdmin);
//                    users.put(login, user);
//                }
//            } finally {
//                rs.close(); // rs can't be null according to the docs
//            }
//        } finally {
//            ps.close();
//        }
//        return users;
//    }
//
//    public static void addNewUser(User user, Connection conn) throws SQLException {
//
//
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (login, pass, isAdmin) VALUES(?, ?, ?)");
//        try {
//            ps.setString(1, user.getLogin());
//            ps.setString(2, user.getPass());
//            ps.setBoolean(3, user.isAdmin());
//            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
//        } finally {
//            ps.close();
//        }
//
//    }
//
//    public static void deleteUser(User user, Connection conn){
//
//    }
//
//    public static void updateUser(User user, Connection conn){
//
//    }
//}
