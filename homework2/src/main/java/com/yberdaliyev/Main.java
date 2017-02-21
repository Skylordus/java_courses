package com.yberdaliyev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String args[]) throws InterruptedException {

        String DBName = "HomeWork2";
        String url = "jdbc:postgresql://localhost:5432/";
        String login = "postgres";
        String password = "postgres";
        PostgreDB myDB = new PostgreDB(DBName,url,login,password);
        ArrayList<String> tables = new ArrayList<>();
        tables.add("main.orders");
        tables.add("main.drivers");
        tables.add("main.clients");
        tables.add("main.cars");

        concurrentDownloading(myDB,tables);
        concurrentUploading(myDB,tables);

        myDB.closeConnection();
    }



    public static void concurrentDownloading(PostgreDB myDB, ArrayList<String> tables) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i=0; i<tables.size(); i++) {
            service.execute( new Extractor(myDB, tables.get(i)));
        }
        service.shutdown();
        while (!service.isTerminated());
        for (int i=0; i<tables.size(); i++) {
            myDB.clearTable(tables.get(i));
        }
    }

    public static void concurrentUploading(PostgreDB myDB, ArrayList<String> tables) throws InterruptedException {

        Collections.reverse(tables);

        ExecutorService service = Executors.newFixedThreadPool(1);

        for (int i = 0; i < tables.size(); i++) {
            service.execute(new Uploader(myDB, tables.get(i)));
        }
        service.shutdown();
        while (!service.isTerminated()) ;
    }
}