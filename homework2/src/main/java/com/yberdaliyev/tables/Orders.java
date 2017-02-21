package com.yberdaliyev.tables;

import com.yberdaliyev.tables.rows.Order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Orders implements Table {
    private ArrayList<Order> orders;

    public Orders() {
        orders = new ArrayList<Order>();
    }
    public Orders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @XmlElement(name="order")
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("order_number");
        columns.add("\"from\"");
        columns.add("\"to\"");
        columns.add("price_per_km");
        columns.add("client");
        columns.add("driver");
        columns.add("fulfilled");
        return columns;
    }

    @Override
    public ArrayList<Order> getValues() {
        return orders;
    }
}
