package JDBC.JDBC;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private int id;
	private String name;
	private double salary;

	
public Employee() {
	
}
	public Employee(int id,String name,double salary)
	{
		super();
		this.id=id;
		this.name=name;
		this.salary=salary;
		
	}


@XmlAttribute
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


@XmlElement
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


@XmlElement
	public double getSalary() {
		return salary;
	}



	@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
}


	public void setSalary(double salary) {
		this.salary = salary;
	}
}
