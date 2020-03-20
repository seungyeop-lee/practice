package springbook.learningtest.spring.embeddeddb;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class EmbeddedDbTest {
	EmbeddedDatabase db;
	SimpleJdbcTemplate template;
	
	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder()	//내장형 데이터베이스의 데이터소스 생성 빌더
				.setType(EmbeddedDatabaseType.HSQL)	//내장형 데이터베이스 종류 지정
				.addScript("classpath:/springbook/learningtest/spring/embeddeddb/schema.sql")	//초기화 스크립트 추가
				.addScript("classpath:/springbook/learningtest/spring/embeddeddb/data.sql")
				.build();	//빌드
		template = new SimpleJdbcTemplate(db);
	}
	
	@After
	public void tearDown() {
		db.shutdown();
	}
	
	@Test
	public void initData() {
		
		assertThat(template.queryForInt("select count(*) from sqlmap"), is(2));
		
		List<Map<String, Object>> list = template.queryForList("select * from sqlmap order by key_");
		assertThat((String)list.get(0).get("key_"), is("KEY1"));
		assertThat((String)list.get(0).get("sql_"), is("SQL1"));
		assertThat((String)list.get(1).get("key_"), is("KEY2"));
		assertThat((String)list.get(1).get("sql_"), is("SQL2"));
		
	}
	
	@Test
	public void insert() {
		template.update("insert into sqlmap(key_, sql_) values(?, ?)", "KEY3", "SQL3");
		assertThat(template.queryForInt("select count(*) from sqlmap"), is(3));
	}
}
