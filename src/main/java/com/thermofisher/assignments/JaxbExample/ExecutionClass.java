package com.thermofisher.assignments.JaxbExample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * This is the main class.
 */
public class ExecutionClass {

    private static Address address(int id, int houseNo, String streetName) {
        Address address = new Address();
        address.setId(id);
        address.setHouseNo(houseNo);
        address.setStreetName(streetName);
        return address;
    }

    private static Customer customer(String name, Address address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        return customer;
    }

    public static void main(String[] args) throws JAXBException {
        Address address1 = address(1, 222, "Piyush Kumar");
        Customer customer = customer("Piyush", address1);

        //Marshalling customer object.
        JAXBContext context1 = JAXBContext.newInstance(Customer.class);
        StringWriter str = new StringWriter();
        Marshaller marshaller1 = context1.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller1.marshal(customer, str);
        String str1 = str.toString();
        System.out.println(str1);

        //Unmarshalling customer object.
        Unmarshaller unmarshaller = context1.createUnmarshaller();
        Customer c1 = (Customer) unmarshaller.unmarshal(new StringReader(str1));
        System.out.println("\n" + c1);
        /*****************************************************************************************************************/

        Address address2 = address(14, 12, "Kameshwar Road");
        Address address3 = address(40, 2, "Paschim Vihar");

        HashMap<Integer, Address> map = new HashMap<Integer, Address>();
        map.put(1, address2);
        map.put(2, address3);

        MapWrapper mapWrapper1 = new MapWrapper();
        mapWrapper1.setMap(map);

        JAXBContext context2 = JAXBContext.newInstance(MapWrapper.class);
        Marshaller marshaller2 = context2.createMarshaller();
        marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller2.marshal(mapWrapper1, new File("/Users/kumarp9/Desktop/xmlFile.xml"));
        marshaller2.marshal(mapWrapper1, System.out);

        JAXBContext context3 = JAXBContext.newInstance(MapWrapper.class);
        Unmarshaller unMarshaller = context3.createUnmarshaller();
        MapWrapper mapWrapper2 = (MapWrapper) unMarshaller.unmarshal(new File("/Users/kumarp9/Desktop/xmlFile.xml"));

        Map<Integer, Address> map2 = mapWrapper2.getMap();
        Set<Integer> set = map2.keySet();

        for (Integer i : set) {
            System.out.println("The value of the set is " + i);

        }

        Set<Map.Entry<Integer, Address>> set1 = map2.entrySet();
        Iterator<Map.Entry<Integer, Address>> itr = set1.iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Address> e = itr.next();
            System.out.println("the value of entry key is " + e.getKey() + " " + "The value of entry value is " + e.getValue());
        }

//To use spring for OXM mapping use following.
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Marshaller marshaller2= (Marshaller)applicationContext.getBean("jaxbMarshallerBean");
//		Employee emp=new Employee();
//		emp.setId(1);
//		emp.setName("Piyush Kumar");
//		emp.setDob("13/02/1990");
//		emp.setCompany_name("Thermofisher Scientific");
//
//		marshaller2.marshal(emp,System.out);
        //System.out.println(mapWrapper2);
    }
}
