package ua.model;

import ua.DataBase.InitDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Chapter {
    private String login;
    private String title ;
    private Date date;

    PreparedStatement ps;

    public Chapter(String login, String title) {
        this.title = title;
        this.login = login;
        this.date = new Date(System.currentTimeMillis());;
    }
    public Chapter() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Map<String, Chapter> getAllChapters() throws SQLException {
        ps = InitDB.conn.prepareStatement("select  * from articles;");
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

    public void addChapter() throws SQLException {
        ps = InitDB.conn.prepareStatement("INSERT INTO chapters (login, title, date_chap) VALUES(?, ?, ?)");
        paramToDB();
    }

    public void deleteChapter() throws SQLException {
        ps = InitDB.conn.prepareStatement("delete  from chapters where id_chapters =" + findId() + ";");


    }

    public void updateChapter() throws SQLException {
        ps = InitDB.conn.prepareStatement("update chapters set login = ?, title = ?, data_chap = ? where id_chapters =" + this.findId() + ";");
        paramToDB();

    }
    public int findId() throws SQLException {
        ps = InitDB.conn.prepareStatement("select id_chapters from chapters where login like '" + getLogin() + "';");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void paramToDB() throws SQLException {
        try {
            ps.setString(1, this.getLogin());
            ps.setString(2, this.getTitle());
            ps.setDate(3, this.getDate());
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }
}
