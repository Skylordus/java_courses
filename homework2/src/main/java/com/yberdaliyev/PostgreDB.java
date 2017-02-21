package com.yberdaliyev;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Yerlan on 16.02.2017.
 */
public class PostgreDB {

    private Connection conn;
    private String dbName;

    public PostgreDB(String dbName, String url, String login, String password) {
        this.dbName = dbName;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url+dbName, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUp(String dbName, String url, String login, String password) {
        this.dbName = dbName;
        try {
            conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String sqlQuery) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String tableName, ArrayList<String> columns, ArrayList<Object> values) {
        if ( (columns.size()!=values.size()) ||
             (columns.isEmpty()) ||
             (values.isEmpty()) )
                throw new IllegalArgumentException("2nd & 3rd parameters must be same size and not empty");

        String sqlQuery = "INSERT INTO "+tableName + " (";
        int size = columns.size();
        for (int i=0; i<size; i++) {
            sqlQuery += columns.get(i);
            if (i!=size-1) sqlQuery += ", ";
        }

        sqlQuery += ") values (";
        for (int i=0; i<size; i++) {
            sqlQuery += "?";
            if (i!=size-1) sqlQuery += ",";
        }
        sqlQuery += ");";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            for (int i=0; i<size; i++) {
                Object obj = values.get(i);
                if ( obj instanceof String ) {
                    preparedStatement.setString(i+1,(String) obj);
                } else if ( obj instanceof Integer ) {
                    preparedStatement.setInt(i+1,(Integer) obj);
                } else if ( obj instanceof Date ) {
                    preparedStatement.setDate(i+1,(Date) obj);
                } else if ( obj instanceof Boolean ) {
                    preparedStatement.setBoolean(i+1,(Boolean) obj);
                }
            }
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateRow(String tableName, String updates, String entrySelector) {
        String sqlQ = "UPDATE " + tableName + " " +
                      "SET " + updates + " " +
                      "WHERE " + entrySelector;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlQ);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearTable(String tableName) {
        String sqlQuery = "DELETE FROM "+tableName;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet selectAll(String tableName) {
        ResultSet resultSet = null;
        try {
            Statement query = conn.createStatement();
            resultSet = query.executeQuery("SELECT * FROM " + tableName);
            return resultSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

}
