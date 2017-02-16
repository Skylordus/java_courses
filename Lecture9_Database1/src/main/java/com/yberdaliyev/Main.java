package com.yberdaliyev;

import java.sql.*;



/**
 * Created by Yerlan on 16.02.2017.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        //Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/Students";
        String login = "postgres";
        String password = "postgres";
        PostgreDB postgreDB = new PostgreDB(url,login,password);

        System.out.println("Selection by name:");
        postgreDB.selectByName("Aleksey aka Lyoh");
        System.out.println("Selection by ID:");
        postgreDB.selectById(1);
        System.out.println("Selection of all entries:");
        postgreDB.selectAll();

        System.out.println("Insertion of Artem:");
        postgreDB.insert("Artem",new Date(1990,01,01),"STC-Tutors","M");
        postgreDB.selectAll();

        System.out.println("Updating name of Aleksey: ");
        postgreDB.updateRow("name=\'Aleksey\',sex=\'F\'","id=2");
        postgreDB.selectAll();

        System.out.println("Deleting row: ");
        postgreDB.deleteRow("name=\'Artem\'");
        postgreDB.selectAll();


        postgreDB.closeConnection();
    }
}
