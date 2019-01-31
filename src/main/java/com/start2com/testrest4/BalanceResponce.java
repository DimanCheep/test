/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.start2com.testrest4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burik
 */
@XmlRootElement
public class BalanceResponce {

    private int code = 0;
    private String error;
    private BalanceValue value;

    @XmlElement
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @XmlElement
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @XmlElement
    public BalanceValue getValue() {
        return value;
    }

    public void setValue(BalanceValue value) {
        this.value = value;
    }

}
