package com.xbeast7.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(    //실제 구동되는 애플리케이션과 동일한 환경을 제공, 그렇기 때문에 무겁다.
//        value = "value=test", //기존의 property를 오버라이드하거나, 없으면 추가 (value, properties의 동시사용불가)
        properties = {"property.value=propertyTest"},   //key=value 형식의 property들을 추가
        classes = {SpringBootTestApplication.class},    //컨텍스트 설정 파일 지정
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //사용 할 웹 환경 지정(현재 설정은 랜덤한 포트 사용 테스트)
public class SpringBootTestApplicationTests {
//    @Value("${value}")
//    private String value;

    @Value("${property.value}")
    private String propertyValue;

    @Test
    public void contextLoads() {
//        assertThat(value, is("test"));
        assertThat(propertyValue, is("propertyTest"));
    }

}
