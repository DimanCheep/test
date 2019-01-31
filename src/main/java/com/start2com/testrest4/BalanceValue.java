/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.start2com.testrest4;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burik
 */
@XmlRootElement
public class BalanceValue {

    private Calendar actualDate;
    private String abonentID;
    private Long amount;
    private String componentID;

    @XmlElement
    public Calendar getActualDate() {
        return actualDate;
    }

    public void setActualDate(Calendar actualDate) {
        this.actualDate = actualDate;
    }

    @XmlElement
    public String getAbonentID() {
        return abonentID;
    }

    public void setAbonentID(String abonentID) {
        this.abonentID = abonentID;
    }

    @XmlElement
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @XmlElement
    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }
}
