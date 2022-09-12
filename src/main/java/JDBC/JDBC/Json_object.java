package JDBC.JDBC;


	
	
	import java.io.File;
	import java.io.IOException;
	import java.lang.reflect.Field;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.text.ParseException;
	import java.util.List;
	import com.fasterxml.jackson.core.type.TypeReference;
	import com.fasterxml.jackson.databind.ObjectMapper;
	public class Json_object {
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException,
	IllegalArgumentException, IllegalAccessException {
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String pass = "root";
	ObjectMapper maper = new ObjectMapper();
	File jsonfile = new File("C:\\Users\\admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\details.json");
	List<Employee1> employeelist = maper.readValue(jsonfile, new TypeReference<List<Employee1>>() { });
	         System.out.println(employeelist);
	Class.forName("org.postgresql.Driver");
	Connection conn = DriverManager.getConnection(url, user, pass);
	for(Employee1 emp : employeelist){
	   //String query = "INSERT INTO employees (id,name,position) VALUES (?,?,?)";
	   Class<?> clap = Employee1.class;
	   StringBuilder query = new StringBuilder();
	   query.append("INSERT INTO employeedetails (");
	   for(Field field: clap.getDeclaredFields()){
	       field.setAccessible(true);
	       query.append(field.getName()).append(",");
	   }
	   query.deleteCharAt(query.length()-1);
	   query.append(") VALUES (");
	   for(Field field: clap.getDeclaredFields()){
	       field.setAccessible(true);
	       query.append("'").append(field.get(emp)).append("'").append(",");
	   }
	   query.deleteCharAt(query.length()-1);
	   query.append(");");
	   System.out.println(query);
	   PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
	   preparedStatement.executeUpdate();
	}

	}
	}





