package webapp;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class MyConnectionProvider implements MyProvider {
	
	final static Logger logger = Logger.getLogger(MyConnectionProvider.class);
	
	static Connection con = null;
	
	public static Connection getCon() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(conUrl,username,password);
			
			
			
		}catch (Exception e){
			logger.error("Greška prilikom povezivanja s bazom. " + e.getMessage());
		}
		return con;
	}
}