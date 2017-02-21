package com.yberdaliyev.tables.rows;


import com.yberdaliyev.tables.all_columns.Born;
import com.yberdaliyev.tables.all_columns.ExperienceYears;
import com.yberdaliyev.tables.all_columns.Id;
import com.yberdaliyev.tables.all_columns.Name;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlRootElement
public class Driver implements Row {
    private Id id;
    private Name name;
    private Born born;
    private ExperienceYears experienceYears;
    private com.yberdaliyev.tables.all_columns.Car car;

    public Driver() {
        id = new Id();
        name = new Name();
        born = new Born();
        experienceYears = new ExperienceYears();
        car = new com.yberdaliyev.tables.all_columns.Car();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Born getBorn() {
        return born;
    }

    public void setBorn(Born born) {
        this.born = born;
    }

    public ExperienceYears getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(ExperienceYears experienceYears) {
        this.experienceYears = experienceYears;
    }

    public com.yberdaliyev.tables.all_columns.Car getCar() {
        return car;
    }

    public void setCar(com.yberdaliyev.tables.all_columns.Car car) {
        this.car = car;
    }

    @Override
    public ArrayList<Object> getValues() {
        ArrayList<Object> list = new ArrayList<>();
        list.add( id.getContent() );
        list.add( name.getContent() );
        list.add( born.getContent() );
        list.add( experienceYears.getContent() );
        list.add( car.getContent() );
        return list;
    }

}
