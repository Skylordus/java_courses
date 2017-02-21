package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="manufacturer")
public class Manufacturer {
    @XmlValue
    private String content = "YerlanTech";

    @XmlAttribute
    private final String type = "String";

    public Manufacturer(String content) {
        this.content = content;
    }

    public Manufacturer() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
