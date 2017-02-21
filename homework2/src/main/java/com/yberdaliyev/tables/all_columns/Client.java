package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="client")
public class Client {
    @XmlValue
    private int content = 0;

    @XmlAttribute
    private String type = "id";

    public Client() {}

    public Client(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

}
