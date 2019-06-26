package com.xbeast7.boot.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoconfigurationApplicationTests {

    //@Value("${propertyKey}") 형식으로 사용

    @Value("${property.test.name}") //depth가 있으면 '.'접근자로 접근가능
    private String propertyTestName;
    
    @Value("${propertyTest}")   //depth가 없으면 일반적으로도 접근가능
    private String propertyTest;

    @Value("${noKey:default value}")    //'[: default value]로 해당 키의 값을 찾지못할 경우 기본값 설정가능
    private String defaultValue;

    @Value("${propertyTestList}")   //','로 연결된 문자열인 경우 배열로 가져오는 것이 가능
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")   //SpEL을 사용하여 ','로 구분지어 List에 매핑
    private List<String> propertyTestList;

    @Test
    public void testValue() {
        assertThat(propertyTestName, is("property depth test"));
        assertThat(propertyTest, is("test"));
        assertThat(defaultValue, is("default value"));

        assertThat(propertyTestArray[0], is("a"));
        assertThat(propertyTestArray[1], is("b"));
        assertThat(propertyTestArray[2], is("c"));

        assertThat(propertyTestList.get(0), is("a"));
        assertThat(propertyTestList.get(1), is("b"));
        assertThat(propertyTestList.get(2), is("c"));
    }
}
