import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class connectingToDBExample {

public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//Loading the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
		//Creating a connection to the database
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://vsdev.vsmidnight.com:1433;databaseName=Midnight_QA;user=AppUser;password=vsau*");
		
		//Executing SQL query and fetching the result
		Statement st = conn.createStatement();
		String sqlStr = "select * from aspnet_Users where UserName = 'ssingh'";
		ResultSet rs = st.executeQuery(sqlStr);
		while (rs.next()) {
			System.out.println(rs.getString("UserName"));
		}		
	}
	
}
