package com.xbeast7.boot.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("fruits")
public class FruitProperties {
    //각 표기법에대해 바인딩이 가능하다.
    private Fruit kebab;
    private Fruit snake;
    private Fruit camel;
    private Fruit normal;
}
