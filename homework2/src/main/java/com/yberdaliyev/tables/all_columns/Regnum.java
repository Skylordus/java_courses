package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="reg_num")
public class Regnum {
    @XmlValue
    private String content = "X000XXX";

    @XmlAttribute
    private final String type = "String";

    public Regnum() {}

    public Regnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 }
