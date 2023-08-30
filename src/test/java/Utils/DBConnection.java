package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection con = null;
	private static Statement stmt  = null;
	static  String JDBC_DRIVER = "org.postgresql.Driver";
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	public DBConnection() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
	}
	
	
	public String database(String EmailAddress)
	{
		String DB_URL = props.getProperty("DB_URL");
		String DB_USER = props.getProperty("DB_USER");
		String DB_PASSWORD = props.getProperty("DB_PASSWORD");
		String Firstname;
		String Lastname;
		String EmailId;
		String OTP = null;
		try{

			System.out.println(EmailAddress);
			//STEP 2: Register JDBC driver
			Class.forName("org.postgresql.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database…");
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

			//STEP 4: Execute a query
			System.out.println("Creating statement…");
			stmt = con.createStatement();
			String sql;
			sql = "select \"firstName\", \"lastName\", email, otp FROM public.\"user\" where email = '"+EmailAddress+"' order by \"createdAt\"  desc ;";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){

			//Retrieve by column name
			// int id  = rs.getInt(1);
			Firstname = rs.getString(1);
			Lastname = rs.getString(2);
			EmailId = rs.getString(3);
			OTP = rs.getString(4);
			
			//Display values
			// System.out.print(" " + model1);
			// System.out.print(" " + model2);
			 System.out.print(" " + EmailId);
			 System.out.println(" " + OTP);
			}

			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			con.close();
			}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			}finally{
			try{
			if(con!=null)
			con.close();
			}catch(SQLException se){
			se.printStackTrace();
			}//end finally try
			}//end try
			System.out.println("DB Connection Closed");

			return OTP;
	}
	
	
}
