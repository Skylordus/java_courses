package com.yberdaliyev.tables.all_columns;

import javax.xml.bind.annotation.*;

/**
 * Created by Yerlan on 19.02.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="experience_years")
public class ExperienceYears {
    @XmlValue
    private int content = 3;

    @XmlAttribute
    private final String type = "Integer";

    public ExperienceYears() {}

    public ExperienceYears(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
 }
