package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="patronymic")
public class Patronymic {
    @XmlValue
    private String content = "Anonymousovich";

    @XmlAttribute
    private final String type = "String";

    public Patronymic() {}

    public Patronymic(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 }
