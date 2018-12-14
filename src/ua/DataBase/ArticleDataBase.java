package ua.DataBase;

import ua.model.Article;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public interface ArticleDataBase {


//    String author ="";
//    String title = "";
//    String textArticle = "";
//
//    public static Map<String, Article> getAllArticle(Connection conn) throws SQLException {
//        PreparedStatement ps = conn.prepareStatement("select  * from article;");
//        Map<String, Article> articles = new HashMap<String, Article>();
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
//                    String author = rs.getString(0);
//                    String title = rs.getString(1);
//                    String textArticle = rs.getString(2);
//                    Article article = new Article(author, title, textArticle);
//                    article.setDate(rs.getDate(3));
//                    articles.put(author, article);
//                }
//            } finally {
//                rs.close(); // rs can't be null according to the docs
//            }
//        } finally {
//            ps.close();
//        }
//        return articles;
//    }

//    public static void addArticle(Article article, Connection conn) throws SQLException {
//            //add
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO Article (author, title, textArticles) VALUES(?, ?, ?)");
//        try {
//            ps.setString(1, article.getAuthor());
//            ps.setString(2, article.getTitle());
//            ps.setString(3, article.getTextArticle());
//            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
//        } finally {
//            ps.close();
//        }
//    }
//
//    public static void deleteArticle(Article article, Connection conn){
//
//        //find in db
//        //delete
//    }
//
//    public static void updateArticle(Article article, Connection conn){
//        //find in db
//        //change in db
//    }
//
//    public static int findId(Article article, Connection conn) throws SQLException {
//        PreparedStatement ps = conn.prepareStatement("select * from Article where author like '" + article.getAuthor() + "';");
//
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//
//        }
//
//
//        // if (article.getAuthor() ==)
//
//
//        return 0;
//
//    }

}
