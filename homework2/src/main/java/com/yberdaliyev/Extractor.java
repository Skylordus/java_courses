package com.yberdaliyev;

import com.yberdaliyev.tables.Cars;
import com.yberdaliyev.tables.Clients;
import com.yberdaliyev.tables.Drivers;
import com.yberdaliyev.tables.Orders;
import com.yberdaliyev.tables.rows.Client;
import com.yberdaliyev.tables.rows.Order;
import javafx.geometry.Pos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.SQLException;

/**
 * Created by Yerlan on 20.02.2017.
 */
public class Extractor implements Runnable {
    private PostgreDB database;
    private String tableName;

    public Extractor(PostgreDB database, String tableName) {
        this.database = database;
        this.tableName = tableName;
    }

    public void run() {
        JAXBContext context = null;
        Object result = null;
        File file = null;
        try {
            if (tableName.equals("main.orders")) {
                result = (Orders) Objectifier.objectify(database,"main.orders");
                context = JAXBContext.newInstance(Orders.class);
                file = new File("orders.xml");
            } else
            if (tableName.equals("main.clients")) {
                result = (Clients) Objectifier.objectify(database,"main.clients");
                context = JAXBContext.newInstance(Clients.class);
                file = new File("clients.xml");
            } else
            if (tableName.equals("main.drivers")) {
                result = (Drivers) Objectifier.objectify(database,"main.drivers");
                context = JAXBContext.newInstance(Drivers.class);
                file = new File("drivers.xml");
            } else
            if (tableName.equals("main.cars")) {
                result = (Cars) Objectifier.objectify(database,"main.cars");
                context = JAXBContext.newInstance(Cars.class);
                file = new File("cars.xml");
            }

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(result, file);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
