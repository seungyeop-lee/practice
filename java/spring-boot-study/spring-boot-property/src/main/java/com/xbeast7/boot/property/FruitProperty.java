package com.xbeast7.boot.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component  //application.yml의 내용을 바인딩 시키기 위해 먼저 빈으로 등록
@ConfigurationProperties("fruit")   //application.yml의 'fruit'이란 키를 가진 값을 이 클래스와 바인딩 시킴
public class FruitProperty {
    private List<Fruit> list;
}
