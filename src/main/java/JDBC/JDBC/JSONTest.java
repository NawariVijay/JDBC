package JDBC.JDBC;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {

	public static void main(String[] args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		ArrayList list = new ArrayList();
		Employee2 e1 = new Employee2(100, "pandu");
		list.add(e1);

		Employee2 e2 = new Employee2(101, "barat");
		list.add(e2);

		String jsonData = mapper.writeValueAsString(list);
		System.out.println(jsonData);

		mapper.writeValue(new File("C:\\Users\\admin\\eclipse-workspace\\JDBC\\data.json"), list);
	}

}

class Employee2 {
	private int empid;
	private String name;

	public Employee2(int empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
