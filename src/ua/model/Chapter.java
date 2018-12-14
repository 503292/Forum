package ua.model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Chapter {
    private String author;
    private String title ;
    private Date createDate;

    static Statement st = null;
    public static Connection conn = null;

    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/forum?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "toor";

    public static void main(String[] args) throws SQLException {
        Chapter cha = new Chapter("admin", "Заголовок");
        cha.setCreateDate(new Date(System.currentTimeMillis()));
        cha.addChapter(cha);
        System.out.println(cha.findId());

    }


    public Chapter(String autor, String title) {
        this.title = title;
        this.author = autor;
        this.createDate = new Date(System.currentTimeMillis());;
    }

    public Chapter() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public static Map<String, Chapter> getAllChapters() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select  * from articles;");
        Map<String, Chapter> chapterMaps = new HashMap<String, Chapter>();
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

                    String author = rs.getString(1);
                    String title = rs.getString(2);
                    Date createDate = rs.getDate(3);

                    Chapter chapter = new Chapter(author,title);
                    chapterMaps.put(author, chapter);
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
        return chapterMaps;
    }

    public void addChapter(Chapter chapter) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO articles (author, title, date_art) VALUES(?, ?, ?)");
        try {
            ps.setString(1, getAuthor());
            ps.setString(2, getTitle());
            ps.setDate(3, getCreateDate());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }

    }

    public void deleteChapter(Chapter chapter) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete  from articles where id =" + findId() + ";");
        ResultSet rs = ps.executeQuery();

    }

    public void updateChapter(Chapter chapter){

    }
    public int findId() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select id from article where author like '" + getAuthor() + "';");

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
