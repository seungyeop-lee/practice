package com.xbeast7.boot.test;

import com.xbeast7.boot.test.domain.Book;
import com.xbeast7.boot.test.service.BookRestService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(BookRestService.class)  //Restclient 전용 테스트 어노테이션, RestTemplate를 사용하는 대상 테스트 서비스클래스를 지정해야 함
public class BookRestTest {

    @Rule   //하나의 테스트 메서드가 끝날 때마다 정의한 값으로 초기화
    public ExpectedException thrown = ExpectedException.none(); //기대하는 예외가 없음을 명시

    @Autowired
    private BookRestService bookRestService;

    @Autowired
    private MockRestServiceServer server;   //테스트용 RestServer 목 생성

    @Test
    public void rest_test() {
        //RestServer에 기대하는 움직임을 정의
        this.server.expect(requestTo("/rest/test")) //해당 URI로 Server에 접속하는 경우
                .andRespond(withSuccess(    //성공에 해당하는 반응을 보냄
                        new ClassPathResource("/test.json", getClass()),    //json파일을 response의 body로 담음
                        MediaType.APPLICATION_JSON));

        Book book = this.bookRestService.getRestBook();

        assertThat(book.getTitle()).isEqualTo("테스트");
    }

    @Test
    public void rest_error_test() {
        this.server.expect(requestTo("/rest/test"))
                .andRespond(withServerError()); //실패에 해당하는 반응을 보냄
        this.thrown.expect(HttpServerErrorException.class); //테스트의 결과로 Exception이 발생하는 것을 기대함을 명시

        this.bookRestService.getRestBook();
    }
}
