package com.start2com.testrest4;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@JacksonXmlRootElement
//@JsonPropertyOrder({"age", "id", "name"})
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class rows {

    //    @XmlAttribute(name = "_id")
//    @XmlID
    private String id = "1";
    //    @XmlElement
    private String name = "2";
    //    @XmlElement
    private String type = "3";
    @XmlElement
    private String code = "1";

    @JacksonXmlElementWrapper(localName = "list")
    public List<String> message = new ArrayList<>(Arrays.asList("message", "error"));


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
