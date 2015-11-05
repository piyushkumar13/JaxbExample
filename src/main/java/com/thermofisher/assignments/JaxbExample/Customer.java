package com.thermofisher.assignments.JaxbExample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement
    private String name;

    @XmlElement(name = "address-root")
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return name + " " + address;

    }
}
