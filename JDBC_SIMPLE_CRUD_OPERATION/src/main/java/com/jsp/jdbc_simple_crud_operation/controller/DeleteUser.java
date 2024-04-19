package com.jsp.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {
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
			String delete="delete from user where id=101";
			statement.executeUpdate(delete);
			if(connection!=null) {
				System.out.println("data delete from database");
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
