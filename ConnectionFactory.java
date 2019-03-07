package br.usjt.web.alunos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

	public static Connection getConnection() throws 
		ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost/bancodeteste?useSSL=false", "root", "jv88888489");

	}
}
