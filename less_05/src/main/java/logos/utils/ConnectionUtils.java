package logos.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "duopew04";
	private  static String URL = "jdbc:mysql://localhost/magazine_shop?useUnicode=true&useJDBC"
			+ "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
		
	public static Connection  openConnection() throws InstantiationException, 
													IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}	
}
