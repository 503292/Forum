package ua.DataBase;

import ua.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public interface ChaptersDataBase {
//    static Connection conn = null;
//
//
//    public static Map<String, User> getAllChapters() throws SQLException {
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
//    public static void createNewUser(){
//
//    }
//
//    public static void deleteUser(){
//
//    }
//
//    public static void updateUser(){
//
//    }
}
