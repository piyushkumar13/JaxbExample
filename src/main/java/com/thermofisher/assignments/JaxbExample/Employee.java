package com.thermofisher.assignments.JaxbExample;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Emp")
public class Employee {

	private int id;
	private String name;
	private String dob;
	private String company_name;
	
	
	@XmlAttribute(name="id")
	public int getId() {
		return id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlElement
	public String getDob() {
		return dob;
	}
	
	@XmlElement
	public String getCompany_name() {
		return company_name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
}
