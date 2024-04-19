package com.jsp.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayUser {
	public static void main(String[] args) {
		Connection connection=null;
		try {
//			step1-load register
			Class.forName("com.mysql.cj.jdbc.Driver");
//			step2-create connection
			String url="jdbc:mysql://localhost:3306/workspace";
			String user="root";
			String pass="Abes@2023";
			
			connection=DriverManager.getConnection(url, user, pass);
//			step3-create statement
			Statement statement=connection.createStatement();
//			step4-execute query
			String display="select *from user";
			ResultSet resultSet = statement.executeQuery(display);
			System.out.println("ALL DATA DISPLAY IN CONSOLE");
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String email=resultSet.getString("email");
				long phone=resultSet.getLong("phone");
				System.out.println("id is "+id);
				System.out.println("name is "+name);
				System.out.println("email is "+email);
				System.out.println("phone is "+phone);
				System.out.println("============================");
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}
