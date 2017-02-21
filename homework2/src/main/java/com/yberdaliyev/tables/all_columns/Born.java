package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;
import java.sql.Date;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="born")
public class Born {

    @XmlValue
    private String content = "2017-02-06";

    @XmlAttribute
    private final String type = "Date";

    public Born() {}

    public Born(Date content) {
        this.content = content.toString();
    }

    public Date getContent() {
        return Date.valueOf(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

}
