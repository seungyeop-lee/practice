package springbook.learningtest.jaxb;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import springbook.user.sqlservice.jaxb.SqlMap;
import springbook.user.sqlservice.jaxb.SqlType;

public class JaxbTest {
	
	@Test
	public void readSqlmap() throws JAXBException, IOException {
		
		//언마샬링 바인딩용 클래스의 위치를 얻음
		String contextPath = SqlMap.class.getPackage().getName();
		//JAXB 컨텍스트를 생성
		JAXBContext context = JAXBContext.newInstance(contextPath);
		//컨텍스트의 정보를 기반으로 언마샬러 생성
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//언마샬링을 할 xml를 인수로 설정하여 언마샬링 수행
		SqlMap sqlMap = (SqlMap) unmarshaller.unmarshal(new File("src/test/resources/sqlmap.xml"));
		//언마살링이 된 객체에서 <sql>태그의 값들을 얻음
		List<SqlType> sqlList = sqlMap.getSql();
		
		assertThat(sqlList.size(), is(3));
		assertThat(sqlList.get(0).getKey(), is("add"));
		assertThat(sqlList.get(0).getValue(), is("insert"));
		assertThat(sqlList.get(1).getKey(), is("get"));
		assertThat(sqlList.get(1).getValue(), is("select"));
		assertThat(sqlList.get(2).getKey(), is("delete"));
		assertThat(sqlList.get(2).getValue(), is("delete"));
		
	}
	
}
