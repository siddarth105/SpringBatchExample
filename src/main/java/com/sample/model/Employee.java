package com.sample.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "EmpDetails")
public class Employee {
	
private List<SpecEmpDetail> specEmpDetailList;
	
	@XmlElement(name = "SpecEmpDetail")
	@XmlElementWrapper(name = "EmpDetails")
	public List<SpecEmpDetail> getSpecEmpDetailList() {
		return specEmpDetailList;
	}
	
	public void setSpecEmpDetailList(List<SpecEmpDetail> specEmpDetailList) {
		this.specEmpDetailList = specEmpDetailList;
	}

}
