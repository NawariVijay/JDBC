package JDBC.JDBC;

import java.io.FileOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;


public class ObjtoXml {

	
	public static void main(String[] args)throws Exception {
		
		
		JAXBContext  obj= JAXBContext.newInstance(Employee.class);
		
		Marshaller marshallerObj = obj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Employee emp1=  new Employee(1,"vijay",200);
		
		marshallerObj.marshal(emp1,new FileOutputStream("C:\\Users\\admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Emp.xml"));
		
	}
}

