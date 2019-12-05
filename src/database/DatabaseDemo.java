package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Database technology
 * Database url
 * Database name and login credentials
 * Table name
 * Table columns name and data types
 */

public class DatabaseDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * Load the driver class related to the DB technology dynamically using
		 * forName() method of Class class
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");

		/*
		 * Create connection to the required database by calling getConnection() method
		 * of DriverManager class and storing reference in Connection class object
		 */
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "user1", "password");

		/*
		 * Create Statement class object by calling createStatement() method of
		 * Connection class so that we can execute SQL queries
		 */
		Statement statement = con.createStatement();
		
		/*
		 * Execute SQL queries using executeQuery() method of Statement class and store
		 * the results in ResultSet class object
		 */
		ResultSet rs = statement.executeQuery("select * from city where District = 'Andhra Pradesh'");
		
		/* Iterate over the results using next() method of ResultSet class */
		while(rs.next()) {
			int id = rs.getInt(1);
			String city = rs.getString(2);
			String country = rs.getString(3);
			String district = rs.getString(4);
			String population = rs.getString(5);
			System.out.println("id = "+id+"\tcity  = "+city+"\tcounntry = "+country+"\tdistrict = "+district+"\tpopulation = "+population);
		}
		
		/* Close the data base connection using close() method of Connection class */
		con.close();
		
	}

}
