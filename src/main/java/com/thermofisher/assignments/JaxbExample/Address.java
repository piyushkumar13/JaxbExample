package com.thermofisher.assignments.JaxbExample;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlAttribute
    private int id;

    @XmlElement
    private String streetName;

    @XmlElement
    private int houseNo;

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getId() {
        return id;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String toString() {
        return id + " " + houseNo + " " + streetName;

    }


}
