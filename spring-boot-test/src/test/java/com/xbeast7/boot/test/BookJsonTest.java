package com.xbeast7.boot.test;

import com.xbeast7.boot.test.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest   //JSON의 직렬화와 역직렬화에 대한 테스트에 필요한 라이브러리 로드
public class BookJsonTest {

    @Autowired
    //Jackson API를 사용하는 테스트
    private JacksonTester<Book> jacsonJson; //간단히 사용가능하지만 역직렬화만 가능하다.

    @Test
    public void jacsonJson_test() throws Exception {
        Book book = Book.builder().title("테스트").build();
        String content = "{\"title\":\"테스트\"}";

        assertThat(this.jacsonJson.parseObject(content).getTitle())
                .isEqualTo(book.getTitle());
        assertThat(this.jacsonJson.parseObject(content).getPublishedAt()).isNull();

        assertThat(this.jacsonJson.write(book)).isEqualToJson("/test.json");
        assertThat(this.jacsonJson.write(book)).hasJsonPathStringValue("title");
        assertThat(this.jacsonJson.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");

    }

}
