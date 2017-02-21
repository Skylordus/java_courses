package com.yberdaliyev.tables.rows;

import com.yberdaliyev.tables.all_columns.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Order implements Row {
    private OrderNumber orderNumber;
    private From from;
    private To to;
    private PricePerKm pricePerKm;
    private com.yberdaliyev.tables.all_columns.Client client;
    private com.yberdaliyev.tables.all_columns.Driver driver;
    private Fulfilled fulfilled;

    public Order() {
        orderNumber = new OrderNumber();
        from = new From();
        to = new To();
        pricePerKm = new PricePerKm();
        client = new com.yberdaliyev.tables.all_columns.Client();
        driver = new com.yberdaliyev.tables.all_columns.Driver();
        fulfilled = new Fulfilled();
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public PricePerKm getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(PricePerKm pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public com.yberdaliyev.tables.all_columns.Client getClient() {
        return client;
    }

    public void setClient(com.yberdaliyev.tables.all_columns.Client client) {
        this.client = client;
    }

    public com.yberdaliyev.tables.all_columns.Driver getDriver() {
        return driver;
    }

    public void setDriver(com.yberdaliyev.tables.all_columns.Driver driver) {
        this.driver = driver;
    }

    public Fulfilled getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Fulfilled fulfilled) {
        this.fulfilled = fulfilled;
    }

    @Override
    public ArrayList<Object> getValues() {
        ArrayList<Object> list = new ArrayList<>();
        list.add( orderNumber.getContent() );
        list.add( from.getContent() );
        list.add( to.getContent() );
        list.add( pricePerKm.getContent() );
        list.add( client.getContent() );
        list.add( driver.getContent() );
        list.add( fulfilled.getContent() );
        return list;
    }

}
