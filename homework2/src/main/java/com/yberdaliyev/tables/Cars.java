package com.yberdaliyev.tables;

import com.yberdaliyev.tables.rows.Car;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Cars implements Table{
    private ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<Car>();
    }
    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @XmlElement(name="car")
    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("manufacturer");
        columns.add("model");
        columns.add("regnum");
        columns.add("color");
        return columns;
    }

    @Override
    public ArrayList<Car> getValues() {
        return cars;
    }
}
