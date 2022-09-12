package JDBC.JDBC;


	
	
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	//import java.io.Reader;
	import java.lang.reflect.Field;
	import java.lang.reflect.Type;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.text.ParseException;
	import java.util.ArrayList;

	import com.google.gson.Gson;
	import com.google.gson.reflect.TypeToken;

	public class Gson_Json_Database {

	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException,
	IllegalArgumentException, IllegalAccessException {
	Class.forName("org.postgresql.Driver");
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String pass = "root";
	Connection con = DriverManager.getConnection(url, user, pass);
	BufferedReader br = new BufferedReader(new FileReader(
	"C:\\Users\\admin\\eclipse-workspace\\JDBC\\src\\main\\java\\JDBC\\JDBC\\details.json"));
	Gson gson = new Gson();
	Type t = new TypeToken<ArrayList<Employee1>>() {
	}.getType();
	ArrayList<Employee1> arr = gson.fromJson(br, t);
	for (Employee1 emp : arr) {
	// String query = "INSERT INTO employees (id,name,position) VALUES (?,?,?)";
	Class<?> clap = Employee1.class;
	StringBuilder query = new StringBuilder();
	query.append("INSERT INTO employeedetails (");
	for (Field field : clap.getDeclaredFields()) {
	field.setAccessible(true);
	query.append(field.getName()).append(",");
	}
	query.deleteCharAt(query.length() - 1);
	query.append(") VALUES (");
	for (Field field : clap.getDeclaredFields()) {
	field.setAccessible(true);
	query.append("'").append(field.get(emp)).append("'").append(",");
	}
	query.deleteCharAt(query.length() - 1);
	query.append(");");
	System.out.println(query);
	PreparedStatement preparedStatement = con.prepareStatement(query.toString());
	preparedStatement.executeUpdate();
	}

	}

	}

	
