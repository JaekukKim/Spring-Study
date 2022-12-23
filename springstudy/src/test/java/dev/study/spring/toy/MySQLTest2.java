package dev.study.spring.toy;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;

public class MySQLTest2 {

	@Inject
	private DataSource dataSource;
	
	@Test
	public void connectTest() {
		try {
			Connection conn = (Connection) dataSource.getConnection();
			System.out.println("연결성공함 conn의 값은? : " + conn);
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
	}

}
