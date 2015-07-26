package util;

import java.sql.*;

public class dbUtil {
	
	public static Connection getConnection() throws Exception{
		
		Connection conn = null;
		
		try {
			
			Class t = Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ustbteach?useUnicode=true&chatacterEncoding=utf8","root","wuzhengliang");
			
		} catch (ClassNotFoundException e){
			
			e.printStackTrace();
			
			throw e;
			
		}
		
		return conn;
		
	}
	
    public static void close(Connection conn) {
    	
    	if (conn != null) {
    		
    		try {
    			
    			conn.close();
    			
    		} catch (SQLException e){
    			
    			e.printStackTrace();
    			
    		}
    	}
    }
    
    public static void main(String[] args) {
    	
    	try {
    		
    		Connection conn;
    		conn = getConnection();
    		System.out.println("Connection is:");
    		System.out.println(conn);
    		
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    }
}
