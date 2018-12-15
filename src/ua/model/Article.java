package ua.model;

import ua.DataBase.InitDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Article {

    private String author;
    private String title;
    private String textArticle;
    private Date date;

    PreparedStatement ps;


    public Article(String author, String title, String textArticle) {
        this.author = author;
        this.title = title;
        this.textArticle = textArticle;
        this.date = new Date(System.currentTimeMillis());
    }

    public Article() {
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextArticle() {
        return textArticle;
    }

    public void setTextArticle(String textArticle) {
        this.textArticle = textArticle;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int findId() throws SQLException {
        PreparedStatement ps = InitDB.conn.prepareStatement("select id_articles from articles where author like '" + getAuthor() + "';");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public static Map<String, Article> getAllArticle() throws SQLException {
        PreparedStatement ps = InitDB.conn.prepareStatement("select  * from articles;");
        Map<String, Article> articlesMaps = new HashMap<String, Article>();
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

                    String author = rs.getString(0);
                    String title = rs.getString(1);
                    String textArticle = rs.getString(2);
                    Article article = new Article(author, title, textArticle);
                    article.setDate(rs.getDate(3));
                    articlesMaps.put(author, article);
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
        return articlesMaps;
    }

    public void addArticle() throws SQLException {
        ps = InitDB.conn.prepareStatement("INSERT INTO articles (author, title, text_article, date_art) VALUES(?, ?, ?, ?)");
        this.paramToDB();
    }

    public void deleteArticle(String sds) throws SQLException {
        int id_delete = findId();
        ps = InitDB.conn.prepareStatement("delete  from articles where id_articles =" + id_delete + ";");
        ResultSet rs = ps.executeQuery();
    }

    public void updateArticle() throws SQLException {
        ps = InitDB.conn.prepareStatement("update articles set (author, title, text_article, date_art) values (?,?,?,?)  where id_articles =" + findId() + ";");
        this.paramToDB();
    }

    public void paramToDB() throws SQLException {
        try {
            ps.setString(1, getAuthor());
            ps.setString(2, getTitle());
            ps.setString(3, getTextArticle());
            ps.setDate(4, getDate());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }


}


