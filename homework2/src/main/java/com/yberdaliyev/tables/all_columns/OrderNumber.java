package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="order_number")
public class OrderNumber {
    @XmlValue
    private int content = 0;

    @XmlAttribute
    private final String type = "Integer";

    public OrderNumber() {}

    public OrderNumber(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
 }
