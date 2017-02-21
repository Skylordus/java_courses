package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="fulfilled")
public class Fulfilled {
    @XmlValue
    private boolean content;

    @XmlAttribute
    private final String type = "Boolean";

    public Fulfilled() {
        content = false;
    }

    public Fulfilled(boolean content) {
        this.content = content;
    }

    public Boolean getContent() {
        return content;
    }

    public void setContent(boolean content) {
        this.content = content;
    }

}
