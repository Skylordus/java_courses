package com.yberdaliyev.tables;

import com.yberdaliyev.tables.rows.Driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Drivers implements Table {
    private ArrayList<Driver> drivers;

    public Drivers() {
        drivers = new ArrayList<Driver>();
    }
    public Drivers(ArrayList<Driver> clients) {
        this.drivers = clients;
    }

    @XmlElement(name="driver")
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("born");
        columns.add("experience_years");
        columns.add("car");
        return columns;
    }

    @Override
    public ArrayList<Driver> getValues() {
        return drivers;
    }
}
