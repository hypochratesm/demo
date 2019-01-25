package com.prj2;

import java.sql.Connection;
import java.sql.DriverManager;

public class JejuConn {
	
	private static Connection jejuConn;
	
	public static Connection getConnection(){
		
		if(jejuConn==null){
			
			try {
										  
				String url = "jdbc:oracle:thin:@192.168.16.20:1521:TestDB";
														    
				String user = "rent";
				String pwd = "rent";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				jejuConn = DriverManager.getConnection(url, user, pwd);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return jejuConn;
		
	}
	
	public static void close(){
		
		if(jejuConn!=null){
			
			try {
				
				if(!jejuConn.isClosed())
					jejuConn.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}						
		}
		
		jejuConn = null;
		
		
	}
	
	
	

}
