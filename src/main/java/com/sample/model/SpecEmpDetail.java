package com.sample.model;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.sample.adapter.JaxbDateAdapter;

@XmlRootElement(namespace = "SpecEmpDetail")
@XmlType(propOrder = {"id", "name", "gender", "designation", "salary", "age", "dob", "type"})
public class SpecEmpDetail {
	
	private int id;
	private String name;
	private String gender;
	private String designation;
	private int salary;
	private int age;
	private Date dob;
	private String type;
	
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "gender")
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@XmlElement(name = "designation")
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@XmlElement(name = "salary")
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@XmlElement(name = "age")
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@XmlElement(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@XmlElement(name = "type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
		
	public SpecEmpDetail() {
		super();
	}
	
	public SpecEmpDetail(int id, String name, String gender, String designation,
			int salary, int age, Date dob, String type) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
		this.salary = salary;
		this.age = age;
		this.dob = dob;
		this.type = type;
	}
	
	public SpecEmpDetail(int id, String name, String gender, String designation,
			int salary, int age, String type) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
		this.salary = salary;
		this.age = age;
		this.type = type;
	}
}
