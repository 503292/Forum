package ua.model;

import ua.DataBase.InitDB;


import java.sql.*;

public class MainDB   {


    public static void main(String[] args) throws SQLException {
        InitDB.getInstance();


            Chapter cha = new Chapter("admin4", "Заголовок4");
            cha.setDate(new Date(System.currentTimeMillis()));
            cha.addChapter();
            System.out.println(cha.findId());


//----------------------------------------------------
//        Article art = new Article("mom2", "Заголовокz2", "шото там про шото2");
//        art.setDate(new Date(System.currentTimeMillis()));
//        art.setTitle("Bishburmak");
//        art.addArticle();
//        System.out.println(art.findId());

//----------------------------------------------------

//        User us = new User("tor12", "tor12", false);
//        us.setAdmin(true);
//        us.addNewUser();
//        us.updateUser();
//
//        System.out.println(us.findUserId());
//        System.out.println(us.isAdmin());
//        System.out.println(us.getPass());



    }
}


