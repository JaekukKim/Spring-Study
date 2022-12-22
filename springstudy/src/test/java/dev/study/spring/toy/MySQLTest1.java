package dev.study.spring.toy;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLTest1 {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/springschema?serverTimezone=UTC";
	private static final String USER = "study";
	private static final String PWD = "1234";
	
	@Test
	public void testConnection() {
		
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("접속성공 ! conn의 값은? : " + conn);
		} catch (Exception e) {
			System.out.println("뭔가이상함.");
			e.printStackTrace();
		}
	}
}
