package com.xbeast7.boot.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitPropertiesTest {

    @Autowired
    FruitProperties fruitProperties;

    @Test
    public void test() {
        assertThat(fruitProperties.getKebab().getColorName(), is("black"));
        assertThat(fruitProperties.getSnake().getColorName(), is("blue"));
        assertThat(fruitProperties.getCamel().getColorName(), is("orange"));
        assertThat(fruitProperties.getNormal().getColorName(), is("pink"));
    }

}