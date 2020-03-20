package org.zerock.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String USER = "root";
	private static final String PW = "root";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			
			System.out.println(con);
			assertThat(con, notNullValue());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
