package com.yberdaliyev;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.sql.*;

/**
 * Created by Yerlan on 16.02.2017.
 */
public class PostgreDB {

    private Connection conn;

    public PostgreDB(String url, String login, String password) {
        try {
            conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUp(String url, String login, String password) {
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

    public void insert(String name, Date date, String group_id, String sex) {
        try {
            String sqlQ = "INSERT INTO main.\"Students\" (name, birthdate, group_id, sex) " +
                    "Values (?,?,?,?)";
            PreparedStatement preparedStatement
                    = conn.prepareStatement(sqlQ);
            preparedStatement.setString(1, name);
            date.setYear(date.getYear()-1900);
            date.setMonth(date.getMonth()-1);
            preparedStatement.setDate(2, date);
            preparedStatement.setString(3, group_id);
            preparedStatement.setString(4,sex);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateRow(String updates, String entrySelector) {
        String sqlQ = "UPDATE main.\"Students\" "  +
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

    public void deleteRow(String deleteCondition) {
        String sqlQ = "DELETE FROM main.\"Students\" "  +
                      "WHERE " + deleteCondition;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlQ);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectById(int id) {
        try {
            Statement query = conn.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM main.\"Students\" " +
                                                          "WHERE id="+id);

            if (resultSet!=null) {
                while (resultSet.next()) {
                    System.out.print(" id = "+resultSet.getInt("id"));
                    System.out.print(" name = "+resultSet.getString("name"));
                    System.out.print(" birthdate = "+resultSet.getString("birthdate"));
                    System.out.print(" group_id = "+resultSet.getString("group_id"));
                    System.out.print(" sex = "+resultSet.getString("sex"));
                    System.out.println();
                    System.out.println();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectByName(String name) {
        try {
            Statement query = conn.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM main.\"Students\" " +
                                                          "WHERE name=\'"+name+"\';");

            if (resultSet!=null) {
                while (resultSet.next()) {
                    System.out.print(" id = "+resultSet.getInt("id"));
                    System.out.print(" name = "+resultSet.getString("name"));
                    System.out.print(" birthdate = "+resultSet.getString("birthdate"));
                    System.out.print(" group_id = "+resultSet.getString("group_id"));
                    System.out.print(" sex = "+resultSet.getString("sex"));
                    System.out.println();
                    System.out.println();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectAll() {
        try {
            Statement query = conn.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM main.\"Students\" ORDER BY id ASC");

            if (resultSet!=null) {
                while (resultSet.next()) {
                    System.out.print(" id = "+resultSet.getInt("id"));
                    System.out.print(" name = "+resultSet.getString("name"));
                    System.out.print(" birthdate = "+resultSet.getString("birthdate"));
                    System.out.print(" group_id = "+resultSet.getString("group_id"));
                    System.out.print(" sex = "+resultSet.getString("sex"));
                    System.out.println();
                    System.out.println();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
