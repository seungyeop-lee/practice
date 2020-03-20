package springbook.learningtest.spring.oxm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.sqlservice.jaxb.SqlMap;
import springbook.user.sqlservice.jaxb.SqlType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration	//locations를 지정하지 않으면 클래스 이름(OxmTest) + -context.xml파일을 찾아서 ApplicationContext의 설정파일로 사용
public class OxmTest {
	@Autowired
	Unmarshaller unmarshaller;
	
	@Test
	public void unmarshallSqlMap() throws XmlMappingException, IOException {
		Source xmlSource = new StreamSource(getClass().getResourceAsStream("sqlmap.xml"));
		SqlMap sqlMap = (SqlMap) this.unmarshaller.unmarshal(xmlSource);
		
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
