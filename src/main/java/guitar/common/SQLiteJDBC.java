package guitar.common;
import java.sql.*;

public class SQLiteJDBC
{
	private String sql;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public static Connection getConnection(){
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:guitar.db");        
	        return conn;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
    }

}	
	 
