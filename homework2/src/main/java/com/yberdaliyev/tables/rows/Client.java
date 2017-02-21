package com.yberdaliyev.tables.rows;

import com.yberdaliyev.tables.all_columns.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Client implements Row {
    private Id id;
    private FirstName firstName;
    private LastName lastName;
    private Patronymic patronymic;
    private DateRegistered dateRegistered;
    private OrdersAmount ordersAmount;

    public Client() {
        id = new Id();
        firstName = new FirstName();
        lastName = new LastName();
        patronymic = new Patronymic();
        dateRegistered = new DateRegistered();
        ordersAmount = new OrdersAmount();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public Patronymic getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(Patronymic patronymic) {
        this.patronymic = patronymic;
    }

    public DateRegistered getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(DateRegistered dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public OrdersAmount getOrdersAmount() {
        return ordersAmount;
    }

    public void setOrdersAmount(OrdersAmount ordersAmount) {
        this.ordersAmount = ordersAmount;
    }

    @Override
    public ArrayList<Object> getValues() {
        ArrayList<Object> list = new ArrayList<>();
        list.add( id.getContent() );
        list.add( firstName.getContent() );
        list.add( lastName.getContent() );
        list.add( patronymic.getContent() );
        list.add( dateRegistered.getContent() );
        list.add( ordersAmount.getContent() );
        return list;
    }
}
