package com.yberdaliyev.tables.rows;

import com.yberdaliyev.tables.all_columns.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Car implements Row {

    private Id id;
    private Manufacturer manufacturer;
    private Model model;
    private Regnum regnum;
    private Color color;

    public Car() {
        id = new Id();
        manufacturer = new Manufacturer();
        model= new Model();
        regnum = new Regnum();
        color = new Color();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Regnum getRegnum() {
        return regnum;
    }

    public void setRegnum(Regnum regnum) {
        this.regnum = regnum;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public ArrayList getValues() {
        ArrayList<Object> list = new ArrayList<>();
        list.add( id.getContent() );
        list.add( manufacturer.getContent() );
        list.add( model.getContent() );
        list.add( regnum.getContent() );
        list.add( color.getContent() );
        return list;
    }
}
