package com.yberdaliyev.tables;


import com.yberdaliyev.tables.rows.Client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Clients implements Table {

    private ArrayList<Client> clients;

    public Clients() {
        clients = new ArrayList<Client>();
    }
    public Clients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @XmlElement(name="client")
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("firstname");
        columns.add("lastname");
        columns.add("patronymic");
        columns.add("date_registered");
        columns.add("orders_amount");
        return columns;
    }

    @Override
    public ArrayList<Client> getValues() {
        return clients;
    }
}
