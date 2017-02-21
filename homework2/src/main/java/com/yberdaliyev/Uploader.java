package com.yberdaliyev;

import com.yberdaliyev.tables.Cars;
import com.yberdaliyev.tables.Clients;
import com.yberdaliyev.tables.Drivers;
import com.yberdaliyev.tables.Orders;
import com.yberdaliyev.tables.rows.Car;
import com.yberdaliyev.tables.rows.Client;
import com.yberdaliyev.tables.rows.Driver;
import com.yberdaliyev.tables.rows.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yerlan on 20.02.2017.
 */
public class Uploader implements Runnable {
    private PostgreDB database;
    private String tableName;

    public Uploader(PostgreDB database, String tableName) {
        this.database = database;
        this.tableName = tableName;
    }

    public void run() {
        JAXBContext context = null;
        File file = null;
        Unmarshaller unmarshaller = null;

        try {
            if (tableName.equals("main.orders")) {
                context = JAXBContext.newInstance(Orders.class);
                file = new File("orders.xml");
                unmarshaller = context.createUnmarshaller();
                Orders orders = (Orders) unmarshaller.unmarshal(file);
                upload(orders);
            } else
            if (tableName.equals("main.clients")) {
                context = JAXBContext.newInstance(Clients.class);
                file = new File("clients.xml");
                unmarshaller = context.createUnmarshaller();
                Clients clients = (Clients) unmarshaller.unmarshal(file);
                upload(clients);
            } else
            if (tableName.equals("main.drivers")) {
                context = JAXBContext.newInstance(Drivers.class);
                file = new File("drivers.xml");
                unmarshaller = context.createUnmarshaller();
                Drivers drivers = (Drivers) unmarshaller.unmarshal(file);
                upload(drivers);
            } else
            if (tableName.equals("main.cars")) {
                context = JAXBContext.newInstance(Cars.class);
                file = new File("cars.xml");
                unmarshaller = context.createUnmarshaller();
                Cars cars = (Cars) unmarshaller.unmarshal(file);
                upload(cars);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private void upload(Object table) {
        ArrayList<String> columns;

        if ( table instanceof Cars ) {
            Cars cars = (Cars) table;
            columns = cars.getColumns();
            for (Car car : cars.getValues() ) {
                database.insert(tableName,columns,car.getValues());
            }
        } else
        if ( table instanceof Clients ) {
            Clients clients = (Clients) table;
            columns = clients.getColumns();
            for (Client client: clients.getValues() ) {
                database.insert(tableName,columns,client.getValues());
            }
        } else
        if ( table instanceof Drivers ) {
            Drivers drivers = (Drivers) table;
            columns = drivers.getColumns();
            for (Driver driver: drivers.getValues() ) {
                database.insert(tableName,columns,driver.getValues());
            }
        } else
        if ( table instanceof Orders ) {
            Orders orders = (Orders) table;
            columns = orders.getColumns();
            for (Order order: orders.getValues() ) {
                database.insert(tableName,columns,order.getValues());
            }
        }

    }
}
