package com.yberdaliyev;

import com.yberdaliyev.tables.Cars;
import com.yberdaliyev.tables.Clients;
import com.yberdaliyev.tables.Drivers;
import com.yberdaliyev.tables.Orders;
import com.yberdaliyev.tables.all_columns.*;
import com.yberdaliyev.tables.rows.*;
import com.yberdaliyev.tables.rows.Car;
import com.yberdaliyev.tables.rows.Client;
import com.yberdaliyev.tables.rows.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
public class Objectifier {

    public static Object objectify(PostgreDB myDB, String tableName) throws SQLException {
        ArrayList list = new ArrayList();
        ResultSet resultSet = myDB.selectAll(tableName);
        if (tableName.equals("main.cars")) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(new Id(resultSet.getInt("id")));
                car.setColor(new Color(resultSet.getString("color")));
                car.setManufacturer(new Manufacturer(resultSet.getString("manufacturer")));
                car.setModel(new Model(resultSet.getString("model")));
                car.setRegnum(new Regnum(resultSet.getString("regnum")));
                list.add(car);
            }
            Cars cars = new Cars(list);
            return cars;
        } else
        if (tableName.equals("main.clients")) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(new Id(resultSet.getInt("id")));
                client.setDateRegistered(new DateRegistered(resultSet.getDate("date_registered")));
                client.setFirstName(new FirstName(resultSet.getString("firstname")));
                client.setLastName(new LastName(resultSet.getString("lastname")));
                client.setOrdersAmount(new OrdersAmount(resultSet.getInt("orders_amount")));
                client.setPatronymic(new Patronymic(resultSet.getString("patronymic")));
                list.add(client);
            }
            Clients clients = new Clients(list);
            return clients;
        } else
        if (tableName.equals("main.drivers")) {
            while (resultSet.next()) {
                Driver driver= new Driver();
                driver.setId(new Id(resultSet.getInt("id")));
                driver.setName(new Name(resultSet.getString("name")));
                driver.setCar(new com.yberdaliyev.tables.all_columns.Car(resultSet.getInt("car")));
                driver.setBorn(new Born(resultSet.getDate("born")));
                driver.setExperienceYears(new ExperienceYears(resultSet.getInt("experience_years")));
                list.add(driver);
            }
            Drivers drivers = new Drivers(list);
            return drivers;
        } else
        if (tableName.equals("main.orders")) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNumber(new OrderNumber(resultSet.getInt("order_number")));
                order.setClient(new com.yberdaliyev.tables.all_columns.Client(resultSet.getInt("client")));
                order.setDriver(new com.yberdaliyev.tables.all_columns.Driver(resultSet.getInt("driver")));
                order.setFrom(new From(resultSet.getString("from")));
                order.setTo(new To(resultSet.getString("to")));
                order.setPricePerKm(new PricePerKm(resultSet.getInt("price_per_km")));
                order.setFulfilled(new Fulfilled(resultSet.getBoolean("fulfilled")));
                list.add(order);
            }
            Orders orders = new Orders(list);
            return orders;
        }
        return null;
    }
}
