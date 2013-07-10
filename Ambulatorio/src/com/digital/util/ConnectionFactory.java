package com.digital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static String status = "";
	
	public static Connection getConnection (){
		
		Connection conn = null;	
		
		try {
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			//String url = "jdbc:mysql://localhost/ambulatorio?user=root&password=654321";
			String url = "jdbc:jtds:sqlserver://localhost:1433/DIGITAL;user=sa;password=sa";
			conn = DriverManager.getConnection(url);
			status = "Conexao aberta";
		
		}catch (ClassNotFoundException e) {
			status = e.getMessage();
			e.printStackTrace();
		}catch (SQLException e) {
			status = e.getMessage();
			e.printStackTrace();
		}catch (Exception e) {
			status = e.getMessage();
			e.printStackTrace();
		}
		//System.out.println(status);
		return conn;
}


}
