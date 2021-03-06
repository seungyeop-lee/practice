package org.zerock.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	@Inject
	private DataSource ds;
	
	@Test
	public void testContection() throws Exception {
		try(Connection con = ds.getConnection()) {
			
			System.out.println(con);
			assertThat(con, notNullValue());
			
		} catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
