package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="orders_amount")
public class OrdersAmount {
    @XmlValue
    private int content = 0;

    @XmlAttribute
    private final String type = "Integer";

    public OrdersAmount() {}

    public OrdersAmount(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
 }

