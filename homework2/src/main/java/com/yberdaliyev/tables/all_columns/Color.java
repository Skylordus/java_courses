package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="color")
public class Color {
    @XmlValue
    private String content = "some color";

    @XmlAttribute
    private final String type = "String";

    public Color(String content) {
        this.content = content;
    }

    public Color() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
