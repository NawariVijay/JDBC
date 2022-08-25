package JDBC.JDBC;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class Jacxb3 {

	public static void main(String[] args) throws Exception {

	    Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
		Statement s = c.createStatement();
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\Employee3.xml");
		JAXBContext r = JAXBContext.newInstance(Jacxb2.class);
		Unmarshaller u = r.createUnmarshaller();
		Jacxb2 a = (Jacxb2) u.unmarshal(f);
		List<Jacxb> employeeList = a.getJacxbList();
		for (Jacxb emp : employeeList) {
			System.out.println(emp.toString());
			Class<?> z = Jacxb.class;
			StringBuilder q = new StringBuilder();
			q.append("insert into employee3(");
			for (Field f1 : z.getDeclaredFields()) {
				f1.setAccessible(true);
				q.append(f1.getName()).append(",");
			}
			q.deleteCharAt(q.length() - 1);
			q.append(")VALUES(");
			for (Field field : z.getDeclaredFields()) {
				field.setAccessible(true);
				q.append("'").append(field.get(emp)).append("'").append(",");
			}
			q.deleteCharAt(q.length() - 1);
			q.append(");");
			System.out.println(q);
			PreparedStatement preparedStatement = c.prepareStatement(q.toString());
			preparedStatement.executeUpdate();
		}

	}

}
