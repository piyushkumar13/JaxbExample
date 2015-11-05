package com.thermofisher.assignments.JaxbExample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement(name = "MapClassPiyush")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapWrapper {

    private HashMap<Integer, Address> map;

    public HashMap<Integer, Address> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, Address> map) {
        this.map = map;
    }
}
