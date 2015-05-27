package com.nixsolutions.chaban.camel.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chaban on 22.05.15.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Files {
    public Files() {
    }

    @XmlAttribute
    private String name;

    @XmlAttribute
    private long size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
