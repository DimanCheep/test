/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.start2com.testrest4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author burik
 */
@XmlRootElement (name = "rows")
public class Greeting implements Serializable {

    private final long id;
    private final String content;


    public Greeting() {
        this.id = 0;
        this.content = null;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @XmlElement
    @XmlElementDecl(name = "row")
    public long getId() {
        return id;
    }

    @XmlElement
    @XmlElementDecl(name = "code")
    public String getContent() {
        return content;
    }
}
