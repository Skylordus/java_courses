package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="lastname")
public class LastName {
    @XmlValue
    private String content = "Anonymousoff";

    @XmlAttribute
    private final String type = "String";

    public LastName() {}

    public LastName(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 }
