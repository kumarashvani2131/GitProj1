package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		boolean flage=false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc");
			System.out.println("this is select record from oracle databse");
			 if(conn!=null)
				 st=conn.createStatement();
			 if(st!=null)
				 rs=st.executeQuery("SELECT * FROM STUDENT");
			 if(rs!=null) {
				 while(rs.next()) {
					 flage=true;
					 System.out.println(rs.getInt(1)+" "+rs.getString(2));
				 }
				 if(flage==false) {
					 System.out.println("data not found");
				 }
			 }
		}catch (SQLException sql) {
			sql.printStackTrace();
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		finally {
			try {
				if(rs!=null)
					rs.close();
			}catch (SQLException sql) {
				sql.printStackTrace();
			}
			
			try {
				if(st!=null)
					st.close();
			}catch (SQLException sql) {
				sql.printStackTrace();
			}
			
			try {
				if(conn!=null)
					conn.close();
			}catch (SQLException sql) {
				sql.printStackTrace();
			}
		}
	}

}
