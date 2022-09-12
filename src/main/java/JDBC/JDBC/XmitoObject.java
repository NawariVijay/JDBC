package JDBC.JDBC;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class XmitoObject {

	public static void main(String[] args) {

		try {
			File f = new File("C:\\Users\\admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Emp.xml");

			JAXBContext obj = JAXBContext.newInstance(Employee.class);
			Unmarshaller unm = obj.createUnmarshaller();
			Employee e = (Employee) unm.unmarshal(f);
			System.out.println(e.getId() + "     " + e.getName() + "    " + e.getSalary());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}