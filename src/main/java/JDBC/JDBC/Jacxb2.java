package JDBC.JDBC;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="datastore")
public class Jacxb2 {
 
    @XmlElement(name="employee")
    private List<Jacxb> employeelist = new ArrayList<>();
    public List<Jacxb> getJacxbList()
    {
        return employeelist;
    }
    
    



}

