package JDBC.JDBC;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement


public class Jacxb {
	
	    private int empid;
	    private String name;
	    private int salary;
	    
	    public Jacxb()
	    {
	        
	    }
	    public Jacxb(int empid,String name,int salary)
	    {
	        super();
	        this.empid=empid;
	        this.name=name;
	        this.salary=salary;
	    }
	    @XmlAttribute
	    
	    public int getempid() {
	        return empid;
	    }
	    public void setempid(int empid) {
	        this.empid = empid;
	    }
	    @XmlElement
	    public String getname() {
	        return name;
	    }
	    public void setname(String name) {
	        this.name = name;
	    }
	    @XmlElement
	    public int getsalary() {
	        return salary;
	    }
	    public void setsalary(int salary) {
	        this.salary = salary;
	    }
	@Override
	public String toString()
	{
	    return "A1[empid ="+empid+",name="+name+",salary = "+salary+"]";
	}
	    
	    




	


}
